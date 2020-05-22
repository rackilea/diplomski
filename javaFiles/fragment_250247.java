public static Texture createBgTexture() {
    Pixmap pixmap = new Pixmap(1, 1, Format.RGBA8888);
    pixmap.setColor(Color.WHITE);
    pixmap.fill();
    Texture texture = new Texture(pixmap); // must be manually disposed
    pixmap.dispose();

    return texture;
}