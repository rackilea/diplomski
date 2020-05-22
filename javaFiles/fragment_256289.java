{
        GL11.glTexCoord2f(0, 1); // added texture coordinate
        GL11.glVertex2i(0, 0);
        GL11.glTexCoord2f(0, 0); // added texture coordinate
        GL11.glVertex2i(0, 256);
        GL11.glTexCoord2f(1, 0); // added texture coordinate
        GL11.glVertex2i(256, 256);
        GL11.glTexCoord2f(1, 1); // added texture coordinate
        GL11.glVertex2i(256, 0);
    }