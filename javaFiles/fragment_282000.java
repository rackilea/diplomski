public class DisplayPanel extends JFrame {

    private JComboBox[] box;
    JTextField[] field1, field2;
    Color col[] = {Color.red, Color.GREEN, Color.blue};
    int i = 0;
    int counter = 0;
    private int boxcount;
    int field1counter = 0;
    int field2counter = 0;

    public DisplayPanel() {
        //super(BorderLayoutTest.class.getName());
        setTitle("Simulation");
        setSize(1000, 500);
        //setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createComponents();
        initComponents();
    }

    private void createComponents() {

        boxcount = 3;
        box = new JComboBox[1 * boxcount];
        field1 = new JTextField[4 * boxcount];
        field2 = new JTextField[5 * boxcount];
    }

    private void initComponents() {
        setLayout(new GridLayout(0, 2));

        for (int i = 0; i < 3; i++) {
            JPanel panel = new JPanel(new BorderLayout());
            box[i] = new JComboBox<>(new String[]{"field1", "field2"});
            panel.add(box[i], BorderLayout.NORTH);
            add(panel);
            add(createPanelWithTextFields(panel));
            box[i].setSelectedIndex(-1);
            box[i].addActionListener(new CustomActionListener());
        }

    }

    private Component createPanelWithTextFields(JPanel panelc) {

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBackground(col[i]);
        System.out.println("......................");
        for (int x = 0; x < 4; x++) {
            System.out.println("iterating .." + (field1counter) + "  counter  " + counter);
            field1[field1counter] = new JTextField("field1 Name " + (x + 1));
            field1[field1counter].setVisible(false);
            panel.add(field1[field1counter]);
            field1counter++;
        }

        for (int x = 0; x < 5; x++) {
            field2[field2counter] = new JTextField("field2 Name " + (x + 1));
            field2[field2counter].setVisible(false);
            panel.add(field2[field2counter]);
            field2counter++;
        }
        i++;
        counter++;
        return panel;
    }

    class CustomActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JComboBox b = (JComboBox) e.getSource();
            int comboidenty = 0;
            for (int k = 0; k < box.length; k++) {
                if (box[k] == b) {
                    break;
                }
                comboidenty++;
            }
            System.out.println(((JPanel) (b.getParent())).getBackground());
            int numChosen = b.getSelectedIndex() + 1;

            System.out.println("hi " + comboidenty);
            switch (numChosen) {
                case 1:
                    for (int x = 0; x < 4; x++) {
                        System.out.println("field1  " + (comboidenty * 4 + x));
                        field1[comboidenty * 4 + x].setVisible(true);
                    }
                    break;
                case 2:
                    for (int x = 0; x < 5; x++) {
                        System.out.println("field2  " + (comboidenty * 5 + x));
                        field2[comboidenty * 5 + x].setVisible(true);
                    }
                    break;
            }

        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DisplayPanel().setVisible(true);
            }
        });

    }
}