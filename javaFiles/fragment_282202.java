static class FileManager {
    private final Function<String, Path> pathFactory;

    FileManager(Function<String, Path> pathFactory) {
        this.pathFactory = pathFactory;
    }

    Path getFilePath(String arg) {
        return pathFactory.apply("/whatever/prefix_" + arg + "_postfix");
    }

    // ...
}