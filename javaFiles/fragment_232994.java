private static void setHeadless(boolean enabled) {
    try {
        Field defaultHeadlessField = java.awt.GraphicsEnvironment.class.getDeclaredField("defaultHeadless");
        defaultHeadlessField.setAccessible(true);
        defaultHeadlessField.set(null, enabled);
        Field headlessField = java.awt.GraphicsEnvironment.class.getDeclaredField("headless");
        headlessField.setAccessible(true);
        headlessField.set(null, enabled);
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    } catch (NoSuchFieldException e) {
        e.printStackTrace();
    }
}