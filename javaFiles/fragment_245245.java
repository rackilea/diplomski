public static void main(String[] args) throws IOException {
    BufferedImage input = ImageIO.read(Test.class.getResource("input.png"));
    int w = input.getWidth();
    int h = input.getHeight();

    BufferedImage output = new BufferedImage(h,w,BufferedImage.TYPE_INT_RGB);
    for (int i=0 ; i<h ; i++) 
        for (int j=0 ; j<w ; j++)
            output.setRGB(i,j,input.getRGB(j,h - i - 1));
    ImageIO.write(output,"png",new File("output.png"));
}