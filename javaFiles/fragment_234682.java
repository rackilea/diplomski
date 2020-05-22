public void downsampling(String inputPath, String outputPath) {
    ArrayList<BufferedImage> inputSequence = new ArrayList<BufferedImage>();

    try (Stream<Path> paths = Files.walk(Paths.get(inputPath))) {
        paths
                .forEach(x -> {
                    try {
                        inputSequence.add(ImageIO.read((InputStream) x));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    } catch (IOException e) {
        e.printStackTrace();
    }
}