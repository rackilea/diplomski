...
if(level.GetRGB(i, j)==Color.WHITE.getRGB()) {
    GL11.glPushMatrix(); // store current matrix
    GL11.glTranslatef(-i, 0, -j);
    ...
    GL11.glPopMatrix(); // instead of GL11.glLoadIdentity()
}