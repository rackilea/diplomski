Image image;
try {    
  URL url = new URL("http://www.google.com/images/logos/ps_logo2.png");
  image = ImageIO.read(url);
} catch (IOException e) {
   ...
}