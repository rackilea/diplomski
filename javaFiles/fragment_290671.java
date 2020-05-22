public static void directoryLoop(File folder) {
    for (final File fileEntry : folder.listFiles()) {
        if (fileEntry.isDirectory()) {
            directoryLoop(fileEntry);
        } else {
            xmlReader(fileEntry.getName());
        }
    }
}