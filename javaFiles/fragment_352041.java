//start points to draw
int blockX=128,blockY=128;
//size of the target rectangle need to be painted
int w=128,h=128;
int[] colors=new int[h*w];
//....init color array
//start painting from x value in array
int colorOffset=0;
//number of value should read from array for one row
int paintWidth=128;
//I think you get the Exception here, because of wrong number passed for drawing pixel for each row
out.setRGB(blockX,blockY, w, h, colors, colorOffset, paintWidth);