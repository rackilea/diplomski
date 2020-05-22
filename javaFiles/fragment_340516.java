GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

GL11.glDisable(GL11.GL_TEXTURE_2D);

GL11.glColor3f(0.5f,0.5f,1.0f);
renderQuad(0, 0, 800, 600);

// render action bar
GL11.glColor3f(0.2f,0.2f,1.0f);
renderQuad(0, 0, 800, 200);

GL11.glColor3f(1.0f,0.0f,0.0f);
renderQuad(50, 50, 100, 60);

renderQuad(200, 50, 100, 60);

GL11.glEnable(GL11.GL_TEXTURE_2D);

// render textured quad
GL11.glColor3f(1.0f, 1.0f, 1.0f);
GL11.glPushMatrix();
GL11.glBindTexture(GL11.GL_TEXTURE_2D, button);
GL11.glBegin(GL11.GL_QUADS);
    GL11.glTexCoord2d(0.0,1.0); 
    GL11.glVertex2f(x, y);
    GL11.glTexCoord2d(1.0,1.0); 
    GL11.glVertex2f(x + width, y);
    GL11.glTexCoord2d(1.0,0.0); 
    GL11.glVertex2f(x + width, y + height);
    GL11.glTexCoord2d(0.0,0.0); 
    GL11.glVertex2f(x, y + height);
GL11.glEnd();
GL11.glPopMatrix();