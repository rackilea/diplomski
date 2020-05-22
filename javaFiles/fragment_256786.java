GL11.glBegin(GL11.GL_QUADS);
GL11.glVertex3f(X.x, X.y, X.z);
GL11.glVertex3f(X.x+v1.x, X.y+v1.y, X.z+v1.z);
GL11.glVertex3f(X.x+v1.x+v2.x, X.y+v1.y+v2.y, X.z+v1.z+v2.z);
GL11.glVertex3f(X.x+v2.x, X.y+v2.y, X.z+v2.z);
GL11.glEnd();