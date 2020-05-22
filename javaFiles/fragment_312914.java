public static void main(final String[] args) throws Exception {
    System.out.println(ManagementFactory.getRuntimeMXBean().getName());
    runCommand("/bin/bash", "-c", "echo $$");
    runCommand("/bin/bash", "-c", "echo $?");
    runCommand("/bin/bash", "-c", "echo $0");
}

private static void runCommand(String... command) throws IOException {
    ProcessBuilder pb = new ProcessBuilder(command);
    Process prs = pb.start();
    try (InputStream is = prs.getInputStream()) {
        byte[] b = ByteStreams.toByteArray(is);
        System.out.println(new String(b, StandardCharsets.UTF_8));
    }
}