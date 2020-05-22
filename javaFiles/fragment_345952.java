final File outputFile = Paths.get("somefile.txt").toFile();
final ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "whatever")
    .redirectOutput(outputFile)
    .redirectErrorStream(true);

final Process p = pb.start();
// etc