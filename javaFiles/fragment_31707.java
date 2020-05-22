private boolean isRunningJavaWebStart() {
    try {
        ServiceManager.getServiceNames();
        return ds != null;
    } catch (NoClassDefFoundError e) {
        return false;
    }
}