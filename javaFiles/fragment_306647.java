public class TestGif {

    private JFrame frame;
    private URL url = null;

    public ArrayList<BufferedImage> getFrames(URL gif) throws IOException{
        ArrayList<BufferedImage> frames = new ArrayList<BufferedImage>();
        ImageReader ir = new GIFImageReader(new GIFImageReaderSpi());
        URLConnection urlconnection = gif.openConnection();
        ir.setInput(ImageIO.createImageInputStream(urlconnection.getInputStream()), false);
        for(int i = 0; i < ir.getNumImages(true); i++){
            ImageReadParam param = ir.getDefaultReadParam();
            frames.add(ir.read(i, param));
        }
        return frames;
    }

    public TestGif() throws FileNotFoundException {
        frame = new JFrame("teste");
        try {
            url = new URL("http://sadpanda.us/images/872436-4CD65DA.gif");
        } catch (MalformedURLException ex) {
            Logger.getLogger(TestGif.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<GifFrame> gifFrames = new ArrayList<GifFrame>();
        ArrayList<BufferedImage> images = null;
        try {
            images = getFrames(url);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        for(BufferedImage image: images)
        {
            int transparantColor = image.getRGB(0, 0); // purple
            BufferedImage gif = ImageUtil.convertRGBAToGIF(image, transparantColor);
            long delay = 100; // every frame takes 100ms
            String disposal = GifFrame.RESTORE_TO_BGCOLOR; // make transparent pixels not 'shine through'
            gifFrames.add(new GifFrame(gif, delay, disposal));
        }

        OutputStream outputStream = new FileOutputStream("C:\\Documents and Settings\\DEVELOPER\\Desktop\\test.gif");

        int loopCount = 0; // loop indefinitely
        try {
            ImageUtil.saveAnimatedGIF(outputStream , gifFrames, loopCount);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        ImageIcon icon = null;
        try {
            icon = new ImageIcon(new File("C:\\Documents and Settings\\DEVELOPER\\Desktop\\test.gif").toURI().toURL());
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JLabel label = new JLabel(icon);
        icon.setImageObserver(label);
        frame.getContentPane().add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                try {
                    new TestGif();
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }
}