Class clazz = ClassLoader.class;
Field field = clazz.getDeclaredField("sys_paths");
boolean accessible = field.isAccessible();
if (!accessible)
    field.setAccessible(true);
Object original = field.get(clazz);
// Reset it to null so that whenever "System.loadLibrary" is called, it
// will be reconstructed with the changed value.
field.set(clazz, null);
try {
    // Change the value and load the library.
    System.setProperty("java.library.path", "./libs/");
    System.loadLibrary("mylibapr");
} finally {
    // Revert back the changes.
    field.set(clazz, original);
    field.setAccessible(accessible);
}