public class HomeTopPanel extends JPanel {

    // BUTTONS
    private final JButton myAccountButton = new JButton("My Account");
    private final JButton updatePhoto = new JButton("Update Photo");

    // PANELS
    private final JPanel rightPanel_1 = new JPanel(new GridBagLayout()) {

        public Dimension getPreferredSize() {

            return new Dimension(1000, 550);
        };
    };
    private final JPanel rightPanel_2 = new JPanel(new GridBagLayout()) {

        public Dimension getPreferredSize() {

            return new Dimension(800, 300);
        };
    };
    private final JPanel logHistoryPanel = new JPanel(new GridBagLayout());

    // BORDERS
    private final Border homeTopPanel_LineBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
    private final Border rightPanel1_LineBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
    private final Border rightPanel2_LineBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
    private final TitledBorder logHistoryPanel_TitledBorder = BorderFactory.createTitledBorder("Log History");

    // LABELS
    private final JLabel imageContainer = new JLabel("User Image");

    // CONSTRAINTS
    GridBagConstraints gbc = new GridBagConstraints();

    // CONSTRUCTOR
    public HomeTopPanel() {

        // METHOD CALLS
        this.setLayout(new GridBagLayout()); // setting of layout should ALWAYS come first before adding constraints and components
        constructMyAccountButton();
        constructRightPanel_1();
        constructRightPanel_2();
        constructLeftPanelComponents();
        setRightPanelBorders();
    }

    public final void constructMyAccountButton() {

        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(myAccountButton, gbc);
    }

    public final void constructRightPanel_1() {

        rightPanel_1.setBackground(Color.RED);
//      rightPanel_1.setPreferredSize(new Dimension(1000, 550));
        gbc.fill = GridBagConstraints.BOTH; // Optional: used for the 2 right panels
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(rightPanel_1, gbc);
    }

    public final void constructRightPanel_2() {

        rightPanel_2.setBackground(Color.BLUE);
//      rightPanel_2.setPreferredSize(new Dimension(800, 300));
        gbc.gridheight = 3;
        rightPanel_1.add(rightPanel_2, gbc);
    }

    public final void constructLeftPanelComponents() {

        gbc.fill = GridBagConstraints.NONE; // Remove if you didn't use it above
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
//      gbc.ipadx = 0;
//      gbc.anchor = GridBagConstraints.PAGE_START;
        rightPanel_1.add(imageContainer, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
//      gbc.anchor = GridBagConstraints.CENTER;
        rightPanel_1.add(updatePhoto, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
//      gbc.anchor = GridBagConstraints.PAGE_END;
        logHistoryPanel.setPreferredSize(new Dimension(110, 100));
        rightPanel_1.add(logHistoryPanel, gbc);
    }

    private void setRightPanelBorders() {

        rightPanel_1.setBorder(rightPanel1_LineBorder);
        rightPanel_2.setBorder(rightPanel2_LineBorder);
        logHistoryPanel.setBorder(logHistoryPanel_TitledBorder);
        this.setBorder(homeTopPanel_LineBorder);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.add(new HomeTopPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}