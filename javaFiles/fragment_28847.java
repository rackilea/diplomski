// Set owner to component on which popup is shown or any of its parents
final Component owner = ...; 
AccessController.doPrivileged(new PrivilegedAction<Void>() {
    @Override
    public Void run() {
        try {
            Field field;
            if (System.getProperty("java.version").startsWith("1.6.0")) {
                Class clazz = Class.forName("javax.swing.PopupFactory");
                field = clazz.getDeclaredField("forceHeavyWeightPopupKey");
            } else { //JDK 1.7.0, 1.8.0
                Class clazz = Class.forName("javax.swing.ClientPropertyKey");
                field = clazz.getDeclaredField("PopupFactory_FORCE_HEAVYWEIGHT_POPUP");
            }
            field.setAccessible(true);
            owner.putClientProperty(field.get(null), Boolean.TRUE);
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }
        return null;
    }
});