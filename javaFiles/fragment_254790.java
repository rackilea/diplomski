String inputFile = ...;
String outputFile = ...;
String logFile = ...;

ProcessBuilder pb = new ProcessBuilder(
        "dita",
        "--input=" + inputFile,
        "--format=pdf",
        "--output=" + outputFile,
        "--logfile=" + logFile)
    .directory(new File("C:\\xyz-3.1.1\\bin"))
    //.inheritIO();
    .redirectErrorStream(true);

Process process = pb.start();