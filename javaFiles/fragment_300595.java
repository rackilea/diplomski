Process processDuration = new ProcessBuilder("ffmpeg", "-i", absolutePath).redirectErrorStream(true).start();
StringBuilder strBuild = new StringBuilder();
try (BufferedReader processOutputReader = new BufferedReader(new InputStreamReader(processDuration.getInputStream(), Charset.defaultCharset()));) {
    String line;
    while ((line = processOutputReader.readLine()) != null) {
        strBuild.append(line + System.lineSeparator());
    }
    processDuration.waitFor();
}
String outputJson = strBuild.toString().trim();