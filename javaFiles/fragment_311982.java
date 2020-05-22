public static void main(String[] args) throws URISyntaxException, IOException {
    File imagesCopy = new File("C:\\Users\\<YOURNAMEHERE>\\images");

    URI uri = ImageCopy.class.getResource("/images").toURI();
    if (!uri.toString().startsWith("file:")) {
        Map<String, String> env = new HashMap<>();
        env.put("create", "true");
        FileSystems.newFileSystem(uri, env);
    }
    Path imagesOrg = Paths.get(uri);
    System.out.println(imagesOrg);

    if (!imagesCopy.exists()) {
        imagesCopy.mkdir();
        try(DirectoryStream<Path> paths = Files.newDirectoryStream(imagesOrg)) {
            for (final Path child : paths) {
                System.out.println(child);
                try {
                    String targetPath = imagesCopy.getAbsolutePath() + File.separator + child.getFileName().toString();
                    System.out.println(targetPath);
                    Files.copy(child, Paths.get(targetPath), StandardCopyOption.REPLACE_EXISTING);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}