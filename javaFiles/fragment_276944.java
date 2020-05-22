private static NinePatch processNinePatchFile(String fname) {
    final Texture t = new Texture(Gdx.files.internal(fname));
    final int width = t.getWidth() - 2;
    final int height = t.getHeight() - 2;
    return new NinePatch(new TextureRegion(t, 1, 1, width, height), 3, 3, 3, 3);
}