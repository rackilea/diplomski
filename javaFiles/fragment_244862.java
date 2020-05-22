int result = 1;
    final File batchFile = new File("C:\\hello world\\MyFile.bat");
    final File outputFile = new File(String.format("C:\\hello world\\output_%tY%<tm%<td_%<tH%<tM%<tS.txt", System.currentTimeMillis()));

    final ProcessBuilder processBuilder = new ProcessBuilder(batchFile.getAbsolutePath());
    processBuilder.redirectErrorStream(true);
    processBuilder.redirectOutput(outputFile);
    processBuilder.directory(new File("C:\\hello world\\"));

    try {
        final Process process = processBuilder.start();
        if (process.waitFor() == 0) {
            result = 0;
        }
        System.out.println("Processed finished with status: " + result);
    } catch (IOException | InterruptedException e) {
        e.printStackTrace();
    }