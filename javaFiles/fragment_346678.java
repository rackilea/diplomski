public class TestLabel extends JLabel {

    private Timer timer;

    private int r = 0;
    private int g = 155;
    private int b = 12;

    public TestLabel() {

        setText("Hello world");
        setOpaque(true);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("tick");

                r = (r + 1) % 255;
                g = (g + 1) % 255;
                b = (b + 1) % 255;

                Color color = new Color(r, g, b);
                setBackground(color);

                System.out.println(color);

                if (r == 0 && b == 0 && g == 0) {

                    r = 0;
                    g = 155;
                    b = 12;

                }

                invalidate();
                revalidate();
                repaint();

            }
        });

        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.start();

    }
}