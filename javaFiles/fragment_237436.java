try (Stream<Path> paths = Files.walk(Paths.get("c:"))) {
        List<String> list = paths
                .map(path -> Files.isDirectory(path) ? path.toString() + '/' : path.toString())
                .collect(Collectors.toList());
    } catch (IOException e) {
        e.printStackTrace();
    }