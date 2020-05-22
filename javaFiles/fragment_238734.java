public void setRotation(float degrees) {
    // TODO: Fix whatever the hell the problem is here.
    GL11.glMatrixMode(GL11.GL_MODELVIEW);
    GL11.glLoadIdentity();
    GL11.glTranslatef(x , y , 0);       
    GL11.glRotatef(degrees, 0f, 0f, 1f);

}