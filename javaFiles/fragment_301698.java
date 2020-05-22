ProcessBuilder pb1 = new ProcessBuilder(
    "/usr/bin/gcc",
    "-o",
    "/home/hipad/hipad/UserProject/example",
    "/home/hipad/hipad/UserProject/example.c");
pb1.redirectError(new File("/home/hipad/hipad/UserProject/example.gccmessages"));