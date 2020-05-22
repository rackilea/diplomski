public class MyFrame extends JFrame {

    public MyFrame() {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                setSize(new Dimension(600, 600));
                setResizable(false);
                JPanel panel = new JPanel() {
                    @Override
                    public void paintComponent(Graphics g) {
                        super.paintComponent(g);

                        g.clearRect(0, 0, 600, 600);
                        Color prevColor = g.getColor();

                        g.setColor(Color.BLUE); // background color
                        g.fillRect(0, 0, 600, 600); // fill a rectangle with background color
                        g.setColor(prevColor);

                        // your custom painting
                        ...
                    }
                };
                getContentPane().add(panel);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true);
            }
        });
    }
}