case RECTANGLE:
        GL11.glColor3f(colour.red, colour.green, colour.blue);
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(-width/2, -height/2);
        GL11.glVertex2f(width/2, -height/2);
        GL11.glVertex2f(width/2, height/2);
        GL11.glVertex2f(-width/2, height/2);
        GL11.glEnd();
        GL11.glMatrixMode(GL11.GL_MODELVIEW); //resetting the rotation
        GL11.glLoadIdentity();  //and translation so that other
                                //objects are unaffected
            break;