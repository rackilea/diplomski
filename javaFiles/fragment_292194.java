public class Engine {

    private int x = 0;
    private int y = 0;
    ArrayList<Color> arr = new ArrayList<Color>();

    public void process() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("res/images.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("img file not found");
        }

        for(int x=0;x<img.getWidth();x++){
            for(int y=0;y<img.getHeight();y++){
                int rgb = img.getRGB(x, y);
                Color c = new Color(rgb);
                arr.add(c);
                System.out.println("x: "+ x + " y:" + y +" color: " + c);
            }
        }
    }
};