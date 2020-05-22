private void makeShape(GL gl, BufferedImage image1, BufferedImage image2) {
    if (texture1 != null) {
        texture1.dispose();
    }
    texture1 = TextureIO.newTexture(image1, false) ;
    if (texture2 != null) {
        texture2.dispose();
    }
    texture2 = TextureIO.newTexture(image2, false) ;
    // ...
}