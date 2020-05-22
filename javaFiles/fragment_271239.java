glEnable(GL_TEXTURE_2D);
glBindTexture(GL_TEXTURE_2D, blockTexture.getID());

glBegin(...); // you have to specify a primitive type

glTexCoord2f(0.0f, 0.0f);
glVertex2i(offsetX * cubeSize + x * cubeSize, y * cubeSize);

glTexCoord2f(1.0f, 0.0f);
glVertex2i((offsetX * cubeSize + x * cubeSize) + cubeSize,
                        y * cubeSize);

glTexCoord2f(1.0f, 1.0f);
glVertex2i((offsetX * cubeSize + x * cubeSize) + cubeSize,
                        (y * cubeSize) + cubeSize);

glTexCoord2f(0.0f, 1.0f);    
glVertex2i(offsetX * cubeSize + x * cubeSize,
                        (y * cubeSize) + cubeSize);

glEnd();

glDisable(GL_TEXTURE_2D);