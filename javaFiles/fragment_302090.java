/*
 * Returns the Manifest for the specified JAR file name.
 */
private static Manifest loadManifest(String fn) {
    try (FileInputStream fis = new FileInputStream(fn);
         JarInputStream jis = new JarInputStream(fis, false))
    {
        return jis.getManifest();
    } catch (IOException e) {
        return null;
    }
}