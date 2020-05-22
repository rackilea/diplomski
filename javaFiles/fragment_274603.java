public class CircleGrid extends JFrame implements ActionListener{

    private CirclePanel[] panels;
    private JButton button;


    public CircleGrid() {
        super("Circle test");

        setLayout(new BorderLayout());

        panels = new CirclePanel[9];
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < panels.length; i++) {
            panels[i] = new CirclePanel();
            center.add(panels[i]);
        }

        button = new JButton("Color in");
        button.addActionListener(this);

        this.add(button, BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(800, 800));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(button)) {
            // select three random circle indices -
            // https://stackoverflow.com/a/42353488/7015661
            ArrayList<Integer> indices = new ArrayList<Integer>();
            int numRandom = 3; // three indices

            for (int i = 0; i < panels.length; i++) {
                indices.add(i);
            }

            Random r = new Random();

            for (int i = 0; i < numRandom; i++) {
                int rndPos1 = r.nextInt(indices.size());
                indices.remove(rndPos1); // remove three indices from the list
            }

            // change panel boolean
            for (int i = 0; i < panels.length; i++) {
                CirclePanel pi = panels[i];

                if(indices.contains(i)) {
                    // no circle
                    pi.setDrawCircle(false);
                }else {
                    //draw circle
                    pi.setDrawCircle(true);
                }
            }

            repaint(); // redraw panels
        }
    }

    public static void main(String[] args) {
        new CircleGrid();
    }
}