CodeSource src = this.getClass().getProtectionDomain().getCodeSource();
    if (src == null) {
        return null;
    }
    URL jarURL = src.getLocation();
    try (JarFile jar = new JarFile(jarURL.getPath());) {
        Enumeration<JarEntry> enumEntries = jar.entries();
        while (enumEntries.hasMoreElements()) {
            JarEntry fileFromJar = (JarEntry) enumEntries.nextElement();
            File toBeCreatedFileLocally = new File(NAME_FOR_TEMPORARY_FOLDER_TO_HOLD_LANG_DATA_FROM_JAR + File.separator + fileFromJar.getName());
            if (fileFromJar.isDirectory()) {
                continue;
            }
            if (fileFromJar.getName().contains(aLanguageDirectoryName)) {
                toBeCreatedFileLocally.getParentFile().mkdirs();
                try (InputStream is = jar.getInputStream(fileFromJar); // get the input stream
                        FileOutputStream fos = new FileOutputStream(toBeCreatedFileLocally)) {
                    while (is.available() > 0) {  // write contents of 'is' to 'fos'
                        fos.write(is.read());
                    }
                }
            }
        }
    } catch (IOException ex) {
        Logger.getLogger(TagDetect.class.getName()).log(Level.SEVERE, null, ex);
    }