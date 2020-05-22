int minPriority = -1;
for (UserRole userRole : userRoles) {
    dbRoles.add(userRole.getRole().getRoleName());

    int rolePriority = userRole.getRole().getPriority();
    if (rolePriority < minPriority || minPriority == -1) {
        minPriority = rolePriority;
    }
    for (RoleAction ra: userRole.getRole().getRoleActions()) {
        System.out.println("#########"+ra.getAction().getName());
        System.out.println("@@@@@@@@@"+ra.getAction().getId());
        map.put(ra.getAction().getName(), ra.getAction().getId());
    }
}