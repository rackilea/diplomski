File outputDirectory = source.getParentFile();
String[] command = {
        "/usr/bin/libreoffice",
        "--headless",
        "--invisible",
        "-env:UserInstallation=file://" + SystemUtils.getJavaIoTmpDir().getAbsolutePath(), // prevent conversion to fail or just do nothing if libreoffice is already running
        "--convert-to",
        "ods",
        "--outdir",
        outputDirectory,
        source.getAbsolutePath()
};
try {
    ProcessBuilder processBuilder = new ProcessBuilder(command);
    processBuilder.directory(outputDirectory);
    Process process = processBuilder.start();
    int returnValue = process.waitFor();
    if (returnValue == 0) {
        log.debug("process ended successfully");
    } else {
        log.error("process ended with error code " + returnValue);
    }
} catch (IOException e) {
    throw new UncheckedIOException("cannot convert " + source, e);
}