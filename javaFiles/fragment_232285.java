String version;
URL jarLocation = new URL("http://www.example.com/app/latestversion.jar");
try (JarInputStream jarStream = new JarInputStream(jarLocation.openStream())) {

    version = jarStream.getManifest().getMainAttributes().getValue(
        Attributes.Name.SPECIFICATION_VERSION);
}