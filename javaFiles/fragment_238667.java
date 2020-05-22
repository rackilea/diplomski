private static void createImage(){
    try{
        String key = "3534";
        BufferedImage thumbnail = new BufferedImage(300, 300,BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = thumbnail.getGraphics();

        randomizePixels(graphics);

        graphics.setColor(new Color(255, 255, 255 ,255));
        graphics.setFont(new Font(null, Font.BOLD, 100));
        graphics.drawString(key, thumbnail.getWidth()/2, thumbnail.getHeight()/2);
        ImageIO.write(thumbnail, "png", new File("image1.png"));
    }catch (Exception e){
        e.printStackTrace();
    }
}
private static void randomizePixels(Graphics graphics){
    Random random = new Random();
    for(int k=0;k<300;k++){
        for(int j=0;j<300;j++){
            graphics.setColor(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat(),1));
            graphics.fillRect(k,j,1,1);
        }
    }
}