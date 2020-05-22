GL11.glPushMatrix();
GL11.glTranslatef(bb.origin.x, bb.origin.y, bb.origin.z); // Translation here
GL11.glRotatef(360.0f - yrot, 0, -1.0f, 0);
GL11.glRotatef(lookupdown, -1.0f, 0, 0);
GL11.glBegin(GL11.GL_QUADS);
GL11.glVertex3f(0.5f, 0.5f, 0); // No translation here anymore
GL11.glVertex3f(0.5f, 0.5f, 0;
GL11.glVertex3f(0.5f, 0.5f, 0);
GL11.glVertex3f(0.5f, 0.5f, 0);
GL11.glEnd();