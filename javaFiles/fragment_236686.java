private class CustomPermissionCollection extends PermissionCollection {

    private static final long serialVersionUID = 5654758059940546018L;

    Collection<Permission> perms = new ArrayList<Permission>();

    @Override
    public void add(Permission permission) {
        perms.add(permission);
    }

    @Override
    public boolean implies(Permission permission) {
        for (Permission p : perms) {
            if (p.implies(permission))
                return true;
        }
        return false;
    }

    @Override
    public Enumeration<Permission> elements() {
        return Collections.enumeration(perms);
    }

}