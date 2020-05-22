public List<String> getProgramAndArguments(PMDParameters params) {
    final List<String> programAndArguments = new ArrayList<String>();
    programAndArguments.add("cmd");
    programAndArguments.add("/c");
    programAndArguments.add("pmd");
    programAndArguments.add("-d");
    programAndArguments.add(params.getSourceCodePath());
    programAndArguments.add("-f");
    programAndArguments.add(params.getOutputFormat());
    programAndArguments.add("-R");
    programAndArguments.add(params.getResultSet());
    programAndArguments.add(">");
    programAndArguments.add(params.getResultsPath());
    return programAndArguments;
}

public void runAnalyzer(PMDParameters params) throws IOException, InterruptedException {
    createProcess();
    processBuilder.command(getProgramAndArguments(params));
    final Process process = processBuilder.start();
    process.waitFor();
}