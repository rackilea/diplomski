public class MainFrame extends JFrame {

    private int levels;
    private int slots;

    private JLabel labelShowLevel;
    private JFormattedTextField textShowLevel;
    private JButton buttonShowLevel;

    private JLabel labelAddEntity;
    private JFormattedTextField textAddEntity;
    private JButton buttonAddEntity;
    private JComboBox cb;

    private JLabel labelRemoveEntity;
    private JFormattedTextField textRemoveEntity;
    private JButton buttonRemoveEntity;

    private JLabel labelSearchEntity;
    private JFormattedTextField textSearchEntity;
    private JButton buttonSearchEntity;

    private JLabel labelEmptySlots;
    private JButton buttonEmptySlots;

    private JLabel levelDispaly;
    private JLabel totalLevels;

    public MainFrame(int levels, int slots) {

        this.levels = levels;
        this.slots = slots;

        getContentPane().add(CreatPanel());

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    JPanel CreatPanel() {

        JPanel panel = new JPanel();

        labelShowLevel = new JLabel("Display Level");
        labelAddEntity = new JLabel("Enter new car/motorbike");
        labelRemoveEntity = new JLabel("Exit car/motorbike");
        labelSearchEntity = new JLabel("Find car/motorbike");
        labelEmptySlots = new JLabel("Get total empty slots");

        textShowLevel = new JFormattedTextField();
        textAddEntity = new JFormattedTextField();
        textRemoveEntity = new JFormattedTextField();
        textSearchEntity = new JFormattedTextField();

        textShowLevel.setPreferredSize(new Dimension(100, HEIGHT));

        buttonShowLevel = new JButton("Show");
        buttonAddEntity = new JButton("Enter");
        buttonRemoveEntity = new JButton("Exit");
        buttonSearchEntity = new JButton("Search");
        buttonEmptySlots = new JButton("Find");

        Font font = new Font("sans comic", Font.ITALIC, 18);
        levelDispaly = new JLabel("Now Displaying Level 0");
        levelDispaly.setFont(font);
        totalLevels = new JLabel("Total Levels:"+ this.levels + " Total slots per level:"
                                    + this.slots);

        String[] items = {"Car", "Motorbike"};
        cb = new JComboBox(items);
        cb.setSelectedItem(items[0]);

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.linkSize(SwingConstants.HORIZONTAL, buttonShowLevel, buttonAddEntity, buttonRemoveEntity, buttonSearchEntity, buttonEmptySlots);

//@formatter:off
        // Horizontal
        GroupLayout.ParallelGroup hGroup = layout.createParallelGroup(Alignment.CENTER); // Will align the labels the way you wanted

        hGroup.addGroup(layout.createSequentialGroup()
                   .addGroup(layout.createParallelGroup()
                             .addComponent(labelShowLevel)
                             .addComponent(labelAddEntity)
                             .addComponent(labelRemoveEntity)
                             .addComponent(labelSearchEntity)
                             .addComponent(labelEmptySlots))
                   .addGroup(layout.createParallelGroup()
                             .addComponent(textShowLevel)
                             .addComponent(textAddEntity)
                             .addComponent(cb)
                             .addComponent(textRemoveEntity)
                             .addComponent(textSearchEntity))
                   .addGroup(layout.createParallelGroup()
                             .addComponent(buttonShowLevel)
                             .addComponent(buttonAddEntity)
                             .addComponent(buttonRemoveEntity)
                             .addComponent(buttonSearchEntity)
                             .addComponent(buttonEmptySlots)));
        hGroup.addComponent(levelDispaly);
        hGroup.addComponent(totalLevels);

        layout.setHorizontalGroup(hGroup);

        // Vertical
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        vGroup.addGroup(layout.createParallelGroup()
                   .addComponent(labelShowLevel)
                   .addComponent(textShowLevel)
                   .addComponent(buttonShowLevel));
        vGroup.addGroup(layout.createParallelGroup()
                   .addComponent(labelAddEntity)
                   .addComponent(textAddEntity));
        vGroup.addGroup(layout.createParallelGroup()
                   .addComponent(cb)
                   .addComponent(buttonAddEntity));
        vGroup.addGroup(layout.createParallelGroup()
                   .addComponent(labelRemoveEntity)
                   .addComponent(textRemoveEntity)
                   .addComponent(buttonRemoveEntity));
        vGroup.addGroup(layout.createParallelGroup()
                   .addComponent(labelSearchEntity)
                   .addComponent(textSearchEntity)
                   .addComponent(buttonSearchEntity));
        vGroup.addGroup(layout.createParallelGroup()
                   .addComponent(labelEmptySlots)
                   .addComponent(buttonEmptySlots));
        vGroup.addGroup(layout.createParallelGroup()
                   .addComponent(levelDispaly));
        vGroup.addGroup(layout.createParallelGroup()
                   .addComponent(totalLevels));

        layout.setVerticalGroup(vGroup);
//@formatter:on

        return panel;
      }

    public static void main(String args[]) {

        EventQueue.invokeLater(() -> new MainFrame(5, 5));
    }
}