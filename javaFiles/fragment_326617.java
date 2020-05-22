try (BufferedReader in = Files.newBufferedReader(Paths.get(inputFile))) {
    char[] buf = new char[4096];
    for (int len; (len = in.read(buf)) > 0; ) {
        // process `len` chars from `buf` here
    }
}