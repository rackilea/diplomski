class GUI extends JFrame {
    private ModelBean model;
    private JCheckBox cbox;

    public GUI(ModelBean model) {
        this.model = model;
        cbox = new JCheckBox("Check and watch me print");
        cbox.addItemListener(new CheckListener(model));

        setLayout(new GridBagLayout());
        add(cbox);
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}