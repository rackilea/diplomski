public static void main(String[] args) {
    // definition of the root directory (adjust according to your system)
    String currentPath = "C:\\";
    Path root = Paths.get(currentPath);

    // get a specific subdirectory by its name
    String specificSubDir = "temp";
    // resolve its name against the root directory
    Path specificSubDirPath = root.resolve(specificSubDir);

    // and check the result
    if (Files.isDirectory(specificSubDirPath)) {
        System.out.println("Path " + specificSubDirPath.toAbsolutePath().toString()
                + " is a directory");
    } else {
        System.err.println("Path " + specificSubDirPath.toAbsolutePath().toString()
                + " is not a directory");
    }
}