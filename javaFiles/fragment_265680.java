public class PixelAccessor<C extends YourColor> {
    public static <C extends YourColor> get(Image<? extends ChannelType<? extends C>> image) {
        return new PixelAccessor<C>(image);
    }

    private final Image<? extends ChannelType<? extends C>> image;

    private PixelAccessor(Image<? extends ChannelType<? extends C>> image) {
        this.image = image;
    }

    public C getPixel(int x, int y) {
        // sadly this is unchecked, but "weak" type systems demand compromises
        @SuppressWarnings("unchecked")
        C color = (C) image.getPixel(x, y);
        return color;
    }
}