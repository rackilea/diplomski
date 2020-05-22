Toolkit.getDefaultToolkit()
        .getSystemClipboard()
        .setContents(new ImageTransferable(myImage), null);

static final class ImageTransferable {
    final BufferedImage image;

    public ImageTransferable(final BufferedImage image) {
        this.image = image;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[] {DataFlavor.imageFlavor};
    }

    @Override
    public boolean isDataFlavorSupported(final DataFlavor flavor) {
        return DataFlavor.imageFlavor.equals(flavor);
    }

    @Override
    public Object getTransferData(final DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (isDataFlavorSupported(flavor)) {
            return image;
        }

        throw new UnsupportedFlavorException(flavor);
    }
};