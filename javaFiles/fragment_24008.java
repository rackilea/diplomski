public static void decompress7ZipEmbedded(File source, File destination) throws IOException {
    ProcessBuilder pb = new ProcessBuilder().inheritIO().command(
            getSevenZipExecutablePath(),
            EXTRACT_WITH_FULL_PATHS_COMMAND,
            source.getAbsolutePath(),
            OUTPUT_DIRECTORY_SWITCH + destination.getAbsolutePath(),
            OVERWRITE_WITHOUT_PROMPT
    );
    processWithSevenZipEmbedded(pb);
}

private static void processWithSevenZipEmbedded(ProcessBuilder pb) throws IOException {
    LOG.info("7-zip command issued: " + String.join(" ", pb.command()));
    pb.start();
}

public class Commands {
    public static final String EXTRACT_WITH_FULL_PATHS_COMMAND = "x"; 
}

public class Switches {
    public static final String OUTPUT_DIRECTORY_SWITCH = "-o";
    public static final String OVERWRITE_WITHOUT_PROMPT = "-aoa";
}