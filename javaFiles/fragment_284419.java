File imgLoc = new File("player.png");
BufferedImage img;
try {
   img = ImageIO.read(imgLoc);
} catch (IOException ex) {
   System.err.println(ex.getMessage());
   ex.printStackTrace();
   throw ex;
}