List<Path> paths = Files.walk(home.toPath()).filter(new Predicate<Path>() {
            @Override
            public boolean test(Path path) {
                return path.toFile().isDirectory();
            }
        }).collect(Collectors.toList());