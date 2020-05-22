public class MainFrame extends JFrame {

    private JPanel btnsPanel;
    private JPanel dialogPanel;

    public MainFrame() {
        getContentPane().setBackground(Color.BLUE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setPreferredSize(new Dimension(600,500));

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.2, 0.1, 0.5, 0.2};
        gridBagLayout.rowWeights = new double[]{0.3, 0.3, 0.15, 0.25};
        getContentPane().setLayout(gridBagLayout);

        btnsPanel = new JPanel();
        btnsPanel.setBackground(Color.RED);
        GridBagConstraints gbc_btnsPanel = new GridBagConstraints();
        gbc_btnsPanel.insets = new Insets(0, 0, 5, 5);
        gbc_btnsPanel.fill = GridBagConstraints.BOTH;
        gbc_btnsPanel.gridx = 0;
        gbc_btnsPanel.gridy = 0;
        gbc_btnsPanel.gridheight = 2;
        getContentPane().add(btnsPanel, gbc_btnsPanel);

        dialogPanel = new JPanel();
        dialogPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        dialogPanel.setBackground(Color.BLUE);
        GridBagConstraints gbc_dialogPanel = new GridBagConstraints();
        gbc_dialogPanel.insets = new Insets(0, 0, 0, 5);
        gbc_dialogPanel.fill = GridBagConstraints.BOTH;
        gbc_dialogPanel.gridx = 2;
        gbc_dialogPanel.gridy = 1;
        gbc_dialogPanel.gridheight = 2;
        getContentPane().add(dialogPanel, gbc_dialogPanel);
        pack();
    }
}