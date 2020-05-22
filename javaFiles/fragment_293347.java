public class CustomLabel extends JLabel {

    static Random rand = new Random();

    public static void main(String args[]) {
        JLayeredPane p = new JLayeredPane();
        p.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        p.setPreferredSize(new Dimension(200, 100));
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                super.mouseClicked(arg0);
                float r = rand.nextFloat();
                float g = rand.nextFloat();
                float b = rand.nextFloat();
                Color randomColor = new Color(r, g, b);
                arg0.getComponent().setBackground(randomColor);
                arg0.getComponent().repaint();
            }
        };
        for (int i = 0; i < 4; i++)
        {
            String labelkey = "Label" +i;
            CustomLabel label = new CustomLabel();
            label.setText(labelkey);
            label.setBounds(10+i*30,10,30,30);
            label.addMouseListener(adapter);
            p.add(label);
        }

        JFrame f = new JFrame();
        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    public CustomLabel(){
    }

    private Color background = Color.white;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Rectangle rect = g.getClipBounds();

        Polygon shape3 = new Polygon();
        shape3.addPoint(rect.x, rect.y + rect.height - 1);
        shape3.addPoint(rect.x + rect.width - 10, rect.y + rect.height - 1);
        shape3.addPoint(rect.x + rect.width - 1, rect.y + rect.height / 2);
        shape3.addPoint(rect.x + rect.width - 10, rect.y);
        shape3.addPoint(rect.x, rect.y);

        g.setColor(Color.LIGHT_GRAY);
        g.drawPolygon(shape3);
        g.setColor(background);
        g.fillPolygon(shape3);
    }

    @Override
    public void setBackground(Color arg0) {
        background = arg0;
    }

}