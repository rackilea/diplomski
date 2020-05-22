final String[] myLocationViaProtectionDomain = {null};
AccessController.doPrivileged(new PrivilegedAction(){
    public Object run(){
        myLocationViaProtectionDomain[0] = getClass().getProtectionDomain().getCodeSource().getLocation().toString();
        debug("myLocationViaProtectionDomain: " + myLocationViaProtectionDomain[0]);
        return null;
    }
});