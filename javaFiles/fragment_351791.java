/** Creates an uninitialized sprite. The sprite will need a texture region and bounds set before it can be drawn. */
public Sprite () {
    setColor(1, 1, 1, 1);
}

/** Creates a sprite with width, height, and texture region equal to the size of the texture. */
public Sprite (Texture texture) {
    this(texture, 0, 0, texture.getWidth(), texture.getHeight());
}