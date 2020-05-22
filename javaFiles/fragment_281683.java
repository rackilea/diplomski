public class IIOMetadataUpdater {

    public static void main(final String[] args) throws IOException {
        File in = new File(args[0]);
        File out = new File(in.getParent(), createOutputName(in));

        System.out.println("Output path: " + out.getAbsolutePath());

        try (ImageInputStream input = ImageIO.createImageInputStream(in);
             ImageOutputStream output = ImageIO.createImageOutputStream(out)) {

            Iterator<ImageReader> readers = ImageIO.getImageReaders(input);
            ImageReader reader = readers.next(); // TODO: Validate that there are readers

            reader.setInput(input);
            IIOImage image = reader.readAll(0, null);

            addTextEntry(image.getMetadata(), "foo", "bar");

            ImageWriter writer = ImageIO.getImageWriter(reader); // TODO: Validate that there are writers
            writer.setOutput(output);
            writer.write(image);
        }

        try (ImageInputStream input = ImageIO.createImageInputStream(out)) {
            Iterator<ImageReader> readers = ImageIO.getImageReaders(input);
            ImageReader reader = readers.next(); // TODO: Validate that there are readers

            reader.setInput(input);
            String value = getTextEntry(reader.getImageMetadata(0), "foo");

            System.out.println("value: " + value);
        }
    }

    private static String createOutputName(final File file) {
        String name = file.getName();
        int dotIndex = name.lastIndexOf('.');

        String baseName = name.substring(0, dotIndex);
        String extension = name.substring(dotIndex);

        return baseName + "_copy" + extension;
    }

    private static void addTextEntry(final IIOMetadata metadata, final String key, final String value) throws IIOInvalidTreeException {
        IIOMetadataNode textEntry = new IIOMetadataNode("TextEntry");
        textEntry.setAttribute("keyword", key);
        textEntry.setAttribute("value", value);

        IIOMetadataNode text = new IIOMetadataNode("Text");
        text.appendChild(textEntry);

        IIOMetadataNode root = new IIOMetadataNode(IIOMetadataFormatImpl.standardMetadataFormatName);
        root.appendChild(text);

        metadata.mergeTree(IIOMetadataFormatImpl.standardMetadataFormatName, root);
    }

    private static String getTextEntry(final IIOMetadata metadata, final String key) {
        IIOMetadataNode root = (IIOMetadataNode) metadata.getAsTree(IIOMetadataFormatImpl.standardMetadataFormatName);
        NodeList entries = root.getElementsByTagName("TextEntry");

        for (int i = 0; i < entries.getLength(); i++) {
            IIOMetadataNode node = (IIOMetadataNode) entries.item(i);
            if (node.getAttribute("keyword").equals(key)) {
                return node.getAttribute("value");
            }
        }

        return null;
    }
}