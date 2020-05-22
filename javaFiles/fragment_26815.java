private static void callJar(String jardir) throws IOException {
    Runtime.getRuntime().exec(jardir);
    if (listen2ExternalProcess()) {
        System.exit(0);
    } else {
        log.warn("Something went wrong...");
    }
}