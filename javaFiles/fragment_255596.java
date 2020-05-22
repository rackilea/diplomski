public class ColorChanger extends JFrame implements MouseListener {
    private Color c =  Color.black;
    private JPanel p = new JPanel () {
        public void paintComponent(Graphics g) {
            g.setColor(c );
            g.drawRect(100, 100, 100, 100);
        }

    };

    public  ColorChanger() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1024, 700));
        addMouseListener(this);
        this.getContentPane().add(p);
        pack();
        setVisible(true);
    }


    public static void main (String arg[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ColorChanger();
            }
        });
    }
    @Override
    public void mouseClicked(MouseEvent arg0) {
        randomizeColor();
        p.repaint();

    }
    private void randomizeColor() {
        switch ((int)(3*Math.random())) {
        case 0:c=Color.red;return;
        case 1:c=Color.blue;return;
        case 2:c=Color.green;return;
        }
    }
    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

}