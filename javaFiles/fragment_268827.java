public class ClockViewer {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            // create frame
            JFrame frame = new JFrame();
            final int Frame_Width = 110;
            final int Frame_Height = 130;

            // set frame attributes
            frame.setSize(Frame_Width, Frame_Height);
            frame.setTitle("A Really Descriptive Title...");

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // get pane attributes
            System.out.println(frame.getContentPane().getWidth());
            System.out.println(frame.getContentPane().getHeight());

            // create ellipse
            JComponent ellipse = new JComponent() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    if (getParent() != null) { //Paint according to parent
                        Graphics g2 = (Graphics2D) g;
                        //Calculations
                        int posX = Math.round(getParent().getWidth() / 100) * 20;
                        int posY = Math.round(getParent().getHeight() / 100) * 20;
                        int Width = Math.round(getParent().getWidth() / 100) * 80;
                        int Height = Math.round(getParent().getHeight() / 100) * 80;
                        g2.drawOval(posX, posY, Width, Height);
                    }
                }
            };
            frame.add(ellipse);
            frame.setVisible(true);
        });

    }
}