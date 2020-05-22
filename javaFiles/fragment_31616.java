try (Stream<Path> paths = Files.find(cobDir, 1,
            (path, attrs) -> attrs.isRegularFile()
                    && path.getFileName().toLowerCase().startsWith(pattern)
                    && path.toString().toLowerCase().endsWith(format))) {
        matchingFile = paths.findFirst();
    } catch (IOException e) {
        logger.error("Problem with getting files to process {}", e.getMessage());
    }