public SampleGraphics extends Graphics2D{

    private final Graphics2D g2d;

    private final BufferedImage buffImg;

    public SampleGraphics(String someargs){
        //Perform things...
        buffImg = .....
        g2d = buffImg.getGraphics();
    }

    @Override
    public Graphics create(){
        return g2d.create();
    }

    //...each method identical to the Graphics2D g2d
}