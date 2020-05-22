glPushMatrix();
glTranslatef(x,y); // move to the proper position
glRotatef( angle, 0, 0, 1 ); // now rotate

glBindTexture(GL_TEXTURE_2D,img.getTextureID());
glBegin(GL_QUADS);
glTexCoord2f(0,0);
glVertex2f(-r,-r);
glTexCoord2f(1,0);
glVertex2f(+r,-r);
glTexCoord2f(1,1);
glVertex2f(+r,+r);
glTexCoord2f(0,1);
glVertex2f(-r,+r);
glEnd();

glPopMatrix(); // pop off the rotation and transformation