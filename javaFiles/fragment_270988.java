public void draw(GL2 gl, int moveX, int moveY) {

    if (texture == null) {
        try {
            texture = TextureIO.newTexture(
                    new File(this.getClass().getClassLoader().getResource("com/world/images/" + type + ".png").getPath()), false);
        } catch (GLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    texture.enable(gl);
    texture.bind(gl);
    gl.glEnable(GL2.GL_TEXTURE_2D);
    gl.glBegin(GL2.GL_QUADS);
    gl.glVertex2f(x * width + moveX, y * width + moveY);
    gl.glTexCoord2f(0, 0);
    gl.glVertex2f(x * width + width + moveX, y * width + moveY);
    gl.glTexCoord2f(1, 0);
    gl.glVertex2f(x * width + width + moveX, y * width + width + moveY);
    gl.glTexCoord2f(1, 1);
    gl.glVertex2f(x * width + moveX, y * width + width + moveY);
    gl.glTexCoord2f(0, 1);
    gl.glEnd();
    gl.glDisable(GL2.GL_TEXTURE_2D);


}