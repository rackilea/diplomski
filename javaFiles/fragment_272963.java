public class ImageApp {

    public static void main(String[] args)  {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                Image image = null;
                try {
                  image = ImageIO.read(getClass().getResource("/images/1.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                JFrame frame = new JFrame("Image App");
                frame.add(new JLabel(new ImageIcon(image)));
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}