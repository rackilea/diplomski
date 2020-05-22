class ShapeFilter extends RGBImageFilter {
    public RedBlueSwapFilter() {
        // The filter's operation does not depend on the
        // pixel's location, so IndexColorModels can be
        // filtered directly.
        canFilterIndexColorModel = true;
    }

    public int filterRGB(int x, int y, int rgb) {
        return (rgb & 0x00_ff_ff_ff) == 0x00_ff_ff_ff // White
               || rgb & 0xff_00_00_00) == 0x00_00_00) // or transparent
               ? rgb : 0xff_ff_00_00; // Red opaque
    }
}