try (Stream<Path> files = Files.walk(Paths.get(localPath))) {
        return files.filter(p -> p.getFileName().toString().endsWith(".png"))
                    .map(p -> new FileInfo(p.getFileName().toString(), p.toFile().length()))
                    .sorted()
                    .collect(Collectors.toList());
    } catch (IOException e) {
        throw new RuntimeException(e);
    }