System.setSecurityManager(new SecurityManager(){
    @Override
    public void checkMemberAccess(Class<?> clazz, int which) {
        throw new SecurityException("Not allowed")
    }
    @Override
    public void checkPermission(Permission perm) {
        // allow resetting the SM
    }
});
ClassTest.class.getMethod("foo");