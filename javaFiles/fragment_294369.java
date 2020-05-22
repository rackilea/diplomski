ClassLoader sysClassLoader = ClassLoader.getSystemClassLoader();
    URI uri = sysClassLoader.getResource("GameBoards").toURI();
    Path gameBoardPath = null;
    if (uri.getScheme().equals("jar")) {
        FileSystem fileSystem = FileSystems.newFileSystem(uri,
                Collections.<String, Object> emptyMap());
        gameBoardPath = fileSystem.getPath("/GameBoards");
    } else {
        gameBoardPath = Paths.get(uri);
    }

    PathVisitor pathVistor = new PathVisitor();
    Files.walkFileTree(gameBoardPath, pathVistor);

    System.out.println(pathVistor.getFileCount());