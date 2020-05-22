String version;
URL versionFile = new URL("http://www.example.com/app/latestversion.jar!/com/example/app/version.txt");
try (BufferedReader versionReader = new BufferedReader(
    new InputStreamReader(versionFile.openStream(), StandardCharsets.UTF_8))) {

    version = versionReader.readLine();
}