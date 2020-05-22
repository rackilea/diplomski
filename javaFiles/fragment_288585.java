public void execute() throws BuildException {
    validateAttributes();

    checkFileExists();

    JarFile jarFile = null;     
    Manifest manifest = null;

    try {
        jarFile = new JarFile(directory + "/" + jar);
        manifest = jarFile.getManifest();
        Attributes attributes = manifest.getMainAttributes();
        String currClasspath = attributes.getValue("Class-Path");

        String newClasspath = currClasspath.concat(" ").concat(append);

        getProject().setProperty(propertyName, newClasspath);           
    } catch (IOException e) {
        throw new BuildException();
    } finally {
        if (manifest != null) {
            manifest = null;
        }
        if (jarFile != null) {
            try {
                jarFile.close();
            } catch (IOException e) {}
            jarFile = null;
        }

    }
}