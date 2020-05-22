public class Main {

    public static void main(String args[]) throws IOException {
        int red[][] = new int[200][300];
        int green[][] = new int[200][300];
        int blue[][] = new int[200][300];
        /////////////////set this matrices 

        BufferedImage image = new BufferedImage(200/*Width*/, 300/*height*/, BufferedImage.TYPE_INT_ARGB);

        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 300; j++) {
                Color c = new Color(red[i][j], green[i][j], blue[i][j]);
                image.setRGB(i, j, c.getRGB());
            }
        }
        ImageIO.write(image, "jpg", new File("/////////////image path.jpg"));
    }
}