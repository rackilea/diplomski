class Cube extends JComponent
{
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                g.setColor(Color.GRAY);
                g.fillRect(i*40, j*40, 40, 40);
            }
        }

        for (int i = 0; i < 50; i++)
        {
            for (int j = 0; j < 50; j++)
            {
                g.setColor(Color.BLACK);
                g.drawRect(i*40, j*40, 40, 40);
            }
        }   
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 1000);
    }

    public static void main(String[] a){
        // use event dispatcher thread
        EventQueue.invokeLater(
            new Runnable() {
                public void run() {
                    Cube cube = new Cube();
                    JScrollPane scroller = new JScrollPane(cube);
                    JFrame window = new JFrame();
                    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    // set the content pane
                    window.setContentPane(scroller);
                    window.pack();
                    window.setVisible(true);
                }
        });
    }
}