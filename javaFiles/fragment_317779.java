public static final String ROLE_PREFIX = "application.";
public static final String ROLE_READ_PERMISSION = "read";
public static final String ROLE_WRITE_PERMISSION = "write";

@Override
public List<RolePermission> getRoles(Backend backend) {
    Map<String, List<String[]>> allRoles = backend.getRoles()
            .stream()
            .map(s -> s.replace(ROLE_PREFIX, "")) // something like "Role1.read"
            .map(s -> s.split("\\.")) // something like ["Role1", "read"]
            .collect(Collectors.groupingBy(split -> split[0]));
    return allRoles.values()
                   .stream()
                   .map(this::buildPermission)
                   .collect(Collectors.toList());
}

private RolePermission buildPermission(List<String[]> roleEntries) {
    RolePermission permission = new RolePermission().setRoleName(roleEntries.get(0)[0]);
    roleEntries.stream()
               .forEach(entry -> {
                   if (ROLE_READ_PERMISSION.equals(entry[1]))
                       permission.setReadAllowed(true);
                   if (ROLE_WRITE_PERMISSION.equals(entry[1]))
                       permission.setWriteAllowed(true);
               });
    return permission;
}