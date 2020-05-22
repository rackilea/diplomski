Path source = Paths.get("c:\\blabla.txt");
    Path target = Paths.get("c:\\blabla2.txt");
    try {
        Files.copy(source, target);
    } catch (IOException e1) {
        e1.printStackTrace();
    }