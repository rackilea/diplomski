/** Returns the paths to all files in a folder. Useful for loading many files without knowing their names.
 * Importantly, this function will work whether or not the application is run from a jar or not.
 * However it might not work if the jar is not run locally.
 *
 * @param folderPath The relative path to the folder with no ending slash.
 * @return A List of path names to all files in that folder.
 * @throws IOException
 */
public static List<String> getPaths(String folderPath) throws IOException {
    final File jarFile = new File(Memory.class.getProtectionDomain().getCodeSource().getLocation().getPath());
    List<String> filePaths = new ArrayList<>();

    if(jarFile.isFile()) {  // Run with JAR file
        final JarFile jar = new JarFile(jarFile);
        final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
        while(entries.hasMoreElements()) {
            final String name = entries.nextElement().getName();
            if (name.startsWith(folderPath + "/")) { //filter according to the folderPath
                filePaths.add(name);
            }
        }
        jar.close();
    } else { // Run with IDE
        final URL url = Memory.class.getResource("/" + folderPath);
        if (url != null) {
            try {
                final File apps = new File(url.toURI());
                for (File app : apps.listFiles()) {
                    filePaths.add(folderPath + "/" + app.getName());
                }
            } catch (URISyntaxException ex) {
                // never happens
            }
        }
    }
    return filePaths;
}