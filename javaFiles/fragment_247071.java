public class CircleDisplay extends JPanel {

    final static int height = 500;
    final static int width = 500;
    Image img = null;
    JFrame frame = new JFrame();

    public static void main(String[] args) {
        new CircleDisplay();
    }

    public CircleDisplay() {
        Image img = null;
        try {
            img = ImageIO
                    .read(new File("f:yellowCircle.png"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        img = 
                img.getScaledInstance(50, 50,
                        Image.SCALE_SMOOTH);
        Button b = new Button(img);
        b.setPreferredSize(new Dimension(50,50));

        add(b);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class Button extends JButton {
    Image img;
    public Button(Image img) {
        this.img = img;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(img,0,0,null);
    }
}