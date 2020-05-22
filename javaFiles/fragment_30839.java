public static void rect(float x, float y, float width, float height, Texture tex) {
    glEnable(GL_TEXTURE_2D);
    glPushMatrix();
    glTranslatef(x, y, 0);        
    glColor4f(1f, 1f, 1f, 1f);
    tex.bind();
    glBegin(GL_QUADS);
    {
        glTexCoord2f(0,1); glVertex2f(0, 0);
        glTexCoord2f(0,0); glVertex2f(0, height);
        glTexCoord2f(1,0); glVertex2f(width, height); 
        glTexCoord2f(1,1); glVertex2f(width, 0);
    }
    glEnd();
    glPopMatrix();
    glDisable(GL_TEXTURE_2D);
}