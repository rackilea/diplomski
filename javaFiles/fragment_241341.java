public Resource<SVG> decode(InputStream source, int width, int height) throws IOException {
    try {
        SVG svg = SVG.getFromInputStream(source);

        svg.setDocumentWidth(width);
        svg.setDocumentHeight(height);
        svg.setDocumentPreserveAspectRatio(PreserveAspectRatio.STRETCH);

        return new SimpleResource<>(svg);
    } catch (SVGParseException ex) {
        throw new IOException("Cannot load SVG from stream.", ex);
    }
}