//Draw some objects here - not rotated

GL11.glPushMatrix(); //Push the matrix onto the stack

//Rotate the object about to be drawn
GL11.glRotatef(rs.rotx, 1F, 0F, 0F);
GL11.glRotatef(rs.roty, 0F, 1F, 0F);
GL11.glRotatef(rs.rotz, 0F, 0F, 1F);

//Draw the object
GL11.glBegin(GL11.GL_QUADS);
GL11.glColor3f(f.clr.red, f.clr.green, f.clr.blue);
GL11.glVertex3f(f.loc.x - f.x, f.loc.y +  f.y, f.loc.z + f.z);
GL11.glVertex3f(f.loc.x + f.x, f.loc.y + f.y, f.loc.z + f.z);
GL11.glVertex3f(f.loc.x + f.x, f.loc.y - f.y, f.loc.z + f.z);
GL11.glVertex3f(f.loc.x - f.x, f.loc.y - f.y, f.loc.z + f.z);
GL11.glEnd();

GL11.glPopMatrix(); //Pop the matrix off of the stack

//Draw some more objects here - not rotated