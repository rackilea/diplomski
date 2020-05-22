BufferedImage img = ImageIO.read(new File("example.bmp"));
// you should stop here
byte[][] green = new byte[30][40];
for(int x=0; x<30; x++){
  for(int y=0; y<40; y++){
     int color = img.getRGB(x,y);
     //alpha[x][y] = (byte)(color>>24);
     //red[x][y] = (byte)(color>>16);
     green[x][y] = (byte)(color>>8);
     //blue[x][y] = (byte)(color);
  }
}
byte[][] inputData = green;