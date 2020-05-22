static void copyTree(Path sourceBase, Path targetBase) throws IOException {
    try {
        Files.walk(sourceBase).forEach(path -> {
            if(Files.isRegularFile(path)) try {
                Path target = targetBase.resolve(sourceBase.relativize(path).toString());
                if(!Files.isDirectory(target.getParent()))
                    Files.createDirectories(target.getParent());
                Files.copy(path, target, StandardCopyOption.COPY_ATTRIBUTES);
            } catch(IOException ex) {
                throw new UncheckedIOException(ex);
            }
        });
    } catch(UncheckedIOException ex) {
        throw ex.getCause();
    }
}