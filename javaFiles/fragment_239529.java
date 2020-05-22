Path adb = Files.createTempFile("adb", ".exe");

try (InputStream stream = Testinghelper.class.getResourceAsStream("adb.exe")) {
    Files.copy(stream, adb, StandardCopyOption.REPLACE_EXISTING);
}

ProcessBuilder builder = new ProcessBuilder(adb.toString(), "devices");