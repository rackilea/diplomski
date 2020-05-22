public void render() {

    GL11.glViewport(0, 0, WIDTH, HEIGHT);

    GL11.glMatrixMode(GL11.GL_PROJECTION);
    GL11.glLoadIdentity();
    GLU.gluPerspective(70, 4f / 3f, 1, 10000);

    GL11.glMatrixMode(GL11.GL_MODELVIEW);   
    glLoadIdentity();
    GL11.glPushMatrix();

    // this is where you set up your view:
    GL11.glTranslatef(x, y, z);
    GL11.glRotatef(rotation, 1, 1, 1);
    GL11.glTranslatef(-x, -y, -z);

    // and now it's time to set the light position:
    GL11.glLight(GL11.GL_LIGHT0, GL11.GL_POSITION, position);

    // we do the rest of the light here as well
    GL11.glLight(GL11.GL_LIGHT0, GL11.GL_AMBIENT, ambient);

    GL11.glEnable(GL11.GL_DEPTH_TEST);
    GL11.glDepthMask(true);
    GL11.glEnable(GL11.GL_CULL_FACE);

    // we enable lighting right before rendering
    GL11.glEnable(GL11.GL_LIGHTING);
    GL11.glEnable(GL11.GL_LIGHT0);    

    GL11.glEnable(GL11.GL_TEXTURE_2D);
    GL11.glBindTexture(GL11.GL_TEXTURE_2D, texID);

    GL11.glColor3f(1f, 1f, 1f);

    GL11.glBegin(GL11.GL_QUADS);

    GL11.glNormal3f(0, 0, -1f);
    GL11.glTexCoord2f(0, 0);
    GL11.glVertex3f(x - dx, y - dy, z - dz);
    GL11.glTexCoord2f(0, 1);
    GL11.glVertex3f(x - dx, y + dy, z - dz);
    GL11.glTexCoord2f(1, 1);
    GL11.glVertex3f(x + dx, y + dy, z - dz);
    GL11.glTexCoord2f(1, 0);
    GL11.glVertex3f(x + dx, y - dy, z - dz);

    // the other five faces

    GL11.glEnd();

    GL11.glPopMatrix();
}