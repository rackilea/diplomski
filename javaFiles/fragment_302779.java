ProcessBuilder builder = new ProcessBuilder().command("where", "where").inheritIO();
builder.redirectOutput(ProcessBuilder.Redirect.PIPE);
Process process = builder.start();

String output;
try (InputStream processStdOut = process.getInputStream()) {
    output = new String(processStdOut.readAllBytes());
}

process.waitFor();