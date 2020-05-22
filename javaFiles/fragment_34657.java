try{
    String path = "/GUI/MatthewPhoto.jpg";
    eastImg = new ImageIcon(ImageIO.read(this.getClass().getResource(path)));
}catch(Exception ex){
    System.out.print(ex);
}