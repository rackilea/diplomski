public final class ImageResourceDemo {
    private static BufferedImage bi;

    public static void main(String[] args){
        try {
            loadImage();

            SwingUtilities.invokeLater(new Runnable(){
                @Override
                public void run() {
                    createAndShowGUI();             
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadImage() throws IOException{
        bi = ImageIO.read(
                ImageResourceDemo.class.getResource("../resource/avatar6.jpeg"));
    }

    private static void createAndShowGUI(){
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.add(new JLabel(new ImageIcon(bi)));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}