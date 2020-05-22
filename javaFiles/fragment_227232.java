public final class Demo {
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
            // handle exception
        }
    }

    private static void loadImage() throws IOException{
        bi = ImageIO.read(Demo.class.getResource("../resources/whitefro1.jpg"));
    }

    private static void createAndShowGUI(){
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE.darker()); // here

        final JLabel labelOne = new JLabel();
        labelOne.setIcon(new ImageIcon(bi));
        final JLabel labelTwo = new JLabel();
        labelTwo.setIcon(new ImageIcon(bi));

        panel.add(labelOne);
        panel.add(labelTwo);
        frame.add(panel);       
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}