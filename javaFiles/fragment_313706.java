try {
    Field fieldSysPath = ClassLoader.class.getDeclaredField("sys_paths");
    fieldSysPath.setAccessible(true);
    fieldSysPath.set(null, null);
} catch (NoSuchFieldException |
        SecurityException |
        IllegalArgumentException |
        IllegalAccessException ex) {
    ex.printStackTrace(System.err);
}