public static InputStream findManifest(final Class<?> clazz) throws IOException,
    URISyntaxException{
    final URL jarUrl =
        clazz.getProtectionDomain().getCodeSource().getLocation();
    final JarFile jf = new JarFile(new File(jarUrl.toURI()));
    final ZipEntry entry = jf.getEntry("META-INF/MANIFEST.MF");
    return entry == null ? null : jf.getInputStream(entry);
}