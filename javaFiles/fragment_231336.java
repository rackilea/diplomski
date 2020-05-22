@SuppressWarnings("serial")
class DrawingSettingWindow extends JDialog {

    private static final String TITLE = "Drawing Setting Window";
    private JComboBox<String> colorsList;
    private JRadioButton normal;
    private JRadioButton filled;

    // not sure what colors is, but I'll make it a String array for testing
    private String[] colors = {"Red", "Orange", "Yellow", "Green", "Blue"};


    public DrawingSettingWindow(Window win) {
        super(win, TITLE, ModalityType.APPLICATION_MODAL);
        // this.setTitle("Drawing Setting Window");
        this.setSize(550, 550); // !! this is not recommended
        this.setLocationRelativeTo(null);

        this.setModal(true);

        this.setLayout(new GridLayout(4, 1));

        JLabel selectColorText = new JLabel("Select Drawing Color");

        colorsList = new JComboBox(colors);
        JPanel panel1 = new JPanel();
        panel1.add(selectColorText);
        panel1.add(colorsList);
        add(panel1);

        JLabel selectStyleText = new JLabel("Select Drawing Style");
        JPanel panel2 = new JPanel();

        normal = new JRadioButton("Normal");
        normal.setSelected(true);
        filled = new JRadioButton("Filled");
        ButtonGroup bg = new ButtonGroup();

        bg.add(normal);
        bg.add(filled);
        panel2.add(selectStyleText);
        panel2.add(normal);
        panel2.add(filled);
        add(panel2);

        JButton ok = new JButton("OK");

        add(ok);

        ok.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        this.pack();
        // this.setVisible(true); // this should be the calling code's responsibility

    }

    public Object getColor() {
        return colorsList.getSelectedItem();
    }

    public boolean getFilled() {
        return filled.isSelected();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Foo");
    }
}