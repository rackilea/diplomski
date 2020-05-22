public static ImageIcon defaultIcon;
static {
   try {
       defaultIcon = ImageIO.read(..);
   } catch (IOException ex){
     System.out.println("No default icon available");
   }
}