Path assetDir = /* ... */;

try (BufferedReader listFile = new BufferedReader(
        new InputStreamReader(
            getClass().getResourceAsStream("assets-list.txt"),
            StandardCharsets.UTF_8))) {

    String assetResource;
    while ((assetResource = listFile.readLine()) != null) {
        Path assetFile = assetDir.resolve(assetResource);
        Files.createDirectories(assetFile.getParent());
        try (InputStream asset = getClass().getResourceAsStream(assetResource)) {
            Files.copy(asset, assetFile);
        }
    }
}