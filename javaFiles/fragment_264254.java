public static void main(String[] args) throws FileNotFoundException, IOException, URISyntaxException {
    CodeSource codeSource = TestJar.class.getProtectionDomain().getCodeSource();
    File jarFile = new File(codeSource.getLocation().toURI().getPath());
    String jarDir = jarFile.getParentFile().getPath();
    FileOutputStream fout = new FileOutputStream(jarDir+"/JarTest.log", true);
    fout.write(jarDir.getBytes());
}