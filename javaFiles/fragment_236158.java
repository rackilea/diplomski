public void deleteTextures() {
    glDeleteTextures(textureID);
}

public static void cleanUpAllTextures() {
    Iterator<Texture> i = textures.iterator();
    while (i.hasNext()) {
        i.next().deleteTextures();
        i.remove();
    }
}