GL11.glVertex2f(0+offs, scale);
GL11.glTexCoord2d(xcoords[x]+0.0769, ycoords[y]+0.25);

GL11.glVertex2f(scale+offs, scale);
GL11.glTexCoord2d(xcoords[x]+0.0769, ycoords[y]);

GL11.glVertex2f(scale+offs, 0);
GL11.glTexCoord2d(xcoords[x], ycoords[y]);

GL11.glVertex2f(0+offs, 0);
GL11.glTexCoord2d(xcoords[x], ycoords[y]+0.25);