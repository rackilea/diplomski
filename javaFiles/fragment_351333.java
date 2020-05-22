public class ImageGrab {

    private static int pixelSimilarityLimit = 20;

    public static void main(String[] args){
        BufferedImage image = null;
        try {
            URL url = new URL("http://animal-photography.com/thumbs/russian_blue_cat_side_view_on_~AP-0PR4DL-TH.jpg");
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Color[] corners = new Color[]{new Color(image.getRGB(0, 0)),
                new Color(image.getRGB(image.getWidth()-1, 0)),
                new Color(image.getRGB(0, image.getHeight()-1)),
                new Color(image.getRGB(image.getWidth()-1, image.getHeight()-1))};

        int avr = 0, avb=0, avg=0, ava=0;
        for(Color c : corners){
            avr += c.getRed();
            avb += c.getBlue();
            avg += c.getGreen();
            ava += c.getAlpha();
        }
        System.out.println(avr/4+","+avg/4+","+avb/4+","+ava/4);

        for(Color c : corners){
            if(Math.abs(c.getRed() - avr/4) < pixelSimilarityLimit &&
                Math.abs(c.getBlue() - avb/4) < pixelSimilarityLimit &&
                Math.abs(c.getGreen() - avg/4) < pixelSimilarityLimit &&
                Math.abs(c.getAlpha() - ava/4) < pixelSimilarityLimit){

            }
            else{
                return;
            }
        }

        Color master = new Color(avr/4, avg/4, avb/4, ava/4);

        System.out.println("Image sufficiently bordered.");

        LinkedList<Pixel> open = new LinkedList<Pixel>();
        LinkedList<Pixel> closed = new LinkedList<Pixel>();
        open.add(new Pixel(0,0));
        open.add(new Pixel(0,image.getHeight()-1));
        open.add(new Pixel(image.getWidth()-1,0));
        open.add(new Pixel(image.getWidth()-1,image.getHeight()-1));

        while(open.size() > 0){
            Pixel p = open.removeFirst();
            closed.add(p);

            for(int i=-1; i<2; i++){
                for(int j=-1; j<2; j++){
                    if(i == 0 && j == 0)
                        continue;
                    if(p.x+i < 0 || p.x+i >= image.getWidth() || p.y+j < 0 || p.y+j >= image.getHeight())
                        continue;

                    Pixel thisPoint = new Pixel(p.x+i, p.y+j); boolean add = true;
                    for(Pixel pp : open)
                        if(thisPoint.x == pp.x && thisPoint.y == pp.y)
                            add = false;
                    for(Pixel pp : closed)
                        if(thisPoint.x == pp.x && thisPoint.y == pp.y)
                            add = false;

                    if(add && areSimilar(master,new Color(image.getRGB(p.x+i, p.y+j)))){
                        open.add(thisPoint);
                    }
                }
            }
        }

        for(Pixel p : closed){
            Color c = new Color(image.getRGB(p.x, p.y));
            Color newC = new Color(0, 0, 0, 0);
            image.setRGB(p.x, p.y, newC.getRGB());
        }

        try {
            File outputfile = new File("C:/Users/Mike/Desktop/saved.png");
            ImageIO.write(image, "png", outputfile);
        } catch (IOException e) {

        }

    }

    public static boolean areSimilar(Color c, Color d){

        if(Math.abs(c.getRed() - d.getRed()) < pixelSimilarityLimit &&
                Math.abs(c.getBlue() - d.getBlue()) < pixelSimilarityLimit &&
                Math.abs(c.getGreen() - d.getGreen()) < pixelSimilarityLimit &&
                Math.abs(c.getAlpha() - d.getAlpha()) < pixelSimilarityLimit){
                return true;
            }
            else{
                return false;
            }

    }

}