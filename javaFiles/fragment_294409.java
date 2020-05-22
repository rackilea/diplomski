ByteBuffer RGB = ByteBuffer.allocateDirect(3); //create a new byte buffer (r, g, b)

int x=1, y=1;

GL11.glReadPixels(x, y, //the x and y of the pixel you want the colour of
1, 1,                   //height, width of selection. 1 since you only want one pixel
GL11.GL_RGB,            //format method uses, get red green and blue
GL11.GL_UNSIGNED_BYTE,  //how the method is performed; using unsigned bytes
RGB);                   //the byte buffer to write to

float red, green, blue;

red = RGB.get(0)/255f,   //get the first byte
green = RGB.get(1)/255f, //the second
blue = RGB.get(2)/255f;  //and third