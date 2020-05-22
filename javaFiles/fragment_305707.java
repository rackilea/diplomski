GL11.glPushMatrix(); // saves the current matrix

GL11.glTranslatef(x, y, z);
GL11.glRotatef(0, 0.0f, 0.0f, 0.0f); // not sure why you have this; it does nothing

// rest of cube rendering code goes here

GL11.glPopMatrix(); // restore the matrix that was saved at the start of the method