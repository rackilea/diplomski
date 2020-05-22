/**
 * Sets the java library path to the specified path
 *
 * @param path the new library path
 * @throws Exception
 */
public static void setLibraryPath(String path) throws Exception {
    System.setProperty("java.library.path", path);

    //set sys_paths to null
    final Field sysPathsField = ClassLoader.class.getDeclaredField("sys_paths");
    sysPathsField.setAccessible(true);
    sysPathsField.set(null, null);
}