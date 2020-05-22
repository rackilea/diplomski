try {
        List<Path> pathsInDir = new ArrayList<>();

        // Dir to scan
        DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(Paths.get("."));

        for(Path path : newDirectoryStream) {
            if(Files.isDirectory(path)) {
                pathsInDir.add(path);
                // recursive call to scan sub dir
            } else {
                // handle files.
            }
        }
    } catch (IOException e) {
        // TODO please handle the exception.
        e.printStackTrace();
    }