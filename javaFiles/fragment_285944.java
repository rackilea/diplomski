public static String getJavaVersion(String javaPath) throws IOException {
    File releaseFile = new File(javaPath, "release");
    BufferedReader bufferedReader = new BufferedReader(new FileReader(releaseFile));
    String version = bufferedReader.readLine();
    return version.substring(version.indexOf("\"") + 1, version.lastIndexOf("\""));
}