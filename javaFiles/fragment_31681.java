public static Image transform(Image in, ColourTransformer f) {
    int width = (int) in.getWidth();
    int height = (int) in.getHeight();
    WritableImage out = new WritableImage(
          width, height);
    for (int x = 0; x < width; x++)
        for (int y = 0; y < height; y++)
            out.getPixelWriter().setColor(x, y, f.apply(x, y, in.getPixelReader().getColor(x, y)));
    return out;

}