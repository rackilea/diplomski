public class MainApp {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Testing");
        ImageIcon icon = createImageIcon("/resources/logo.png");
        JLabel label1 = new JLabel("Image and Text", icon, JLabel.CENTER);

        //Set the position of the text, relative to the icon:
        label1.setVerticalTextPosition(JLabel.BOTTOM);
        label1.setHorizontalTextPosition(JLabel.CENTER);

        frame.getContentPane().add(label1);
        frame.pack();
        frame.setVisible(true);
    }

    protected static ImageIcon createImageIcon(String path) {
        URL imgURL = MainApp.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}