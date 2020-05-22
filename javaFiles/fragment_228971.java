Map<WatchKey, Path> keys = new HashMap<>();

    try {
        Path path = Paths.get("<directory u want to watch>");
        FileSystem fileSystem = path.getFileSystem();
        WatchService service = fileSystem.newWatchService();

        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    if (<directory you want to exclude>) {
                            return FileVisitResult.SKIP_SUBTREE;
                    }

                    WatchKey key = dir.register(service, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
                    keys.put(key, dir);
                    return FileVisitResult.CONTINUE;
                }
        });

        WatchKey key = null;
        while (true) {
            key = service.take();
            while (key != null) {
                WatchEvent.Kind<?> kind;
                for (WatchEvent<?> watchEvent : key.pollEvents()) {
                    kind = watchEvent.kind();
                    if (OVERFLOW == kind) {
                        continue;
                    }

                    Path filePath = ((WatchEvent<Path>) watchEvent).context();
                    Path absolutePath = keys.get(key).resolve(filePath);

                    if (kind == ENTRY_CREATE) {
                        if (Files.isDirectory(absolutePath, LinkOption.NOFOLLOW_LINKS)) {
                            WatchKey newDirKey = absolutePath.register(service, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
                            keys.put(newDirKey, absolutePath);
                        }
                    }

                }
                if (!key.reset()) {
                    break; // loop
                }
            }
        }
    } catch (Exception ex) {
    }