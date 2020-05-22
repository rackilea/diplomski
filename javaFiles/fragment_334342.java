static boolean isWindows() {
    return System.getProperty("os.name").toLowerCase().contains("win");
}

static String npm = isWindows() ? "npm.cmd" : "npm";

static void run() {
    Process process = new ProcessBuilder(npm, "update")
            .directory(navigatePath)
            .start()
}