public Texture (String internalPath) {
    this(Gdx.files.internal(internalPath));
}

public Texture (FileHandle file) {
    this(file, null, false);
}