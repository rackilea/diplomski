ProcessBuilder pb = new ProcessBuilder(
    "C:/Program Files/WinRAR/winrar",
    "x",
    "myjar.jar",
    "*.*",
    "new");
pb.directory(new File("H:/"));
pb. redirectErrorStream(true);

Process p = pb.start();