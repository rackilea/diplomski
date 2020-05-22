public class OverlayAnchorPanel extends JPanel implements ItemListener {
    private static final long serialVersionUID = 1L;

    private AnchorChangeListener anchorListener;
    private JRadioButton rdbtnSouthEast;
    private JRadioButton rdbtnSouthWest;
    private JRadioButton rdbtnNorthWest;
    private JRadioButton rdbtnNorthEast;
    private ButtonGroup radioGroup;
    private JPanel panel;

    /**
     * Create the panel.
     */
    public OverlayAnchorPanel() {
        this.radioGroup = new ButtonGroup();;
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] {0};
        gridBagLayout.rowHeights = new int[] {0};
        gridBagLayout.columnWeights = new double[]{0.0};
        gridBagLayout.rowWeights = new double[]{0.0};
        setLayout(gridBagLayout);

        panel = new JPanel();
        panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Anchor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.anchor = GridBagConstraints.NORTHWEST;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 0;
        add(panel, gbc_panel);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[] {0, 0};
        gbl_panel.rowHeights = new int[] {0, 0};
        gbl_panel.columnWeights = new double[]{0.0, 0.0};
        gbl_panel.rowWeights = new double[]{0.0, 0.0};
        panel.setLayout(gbl_panel);

        rdbtnNorthEast = new JRadioButton("");
        GridBagConstraints gbc_rdbtnNorthEast = new GridBagConstraints();
        gbc_rdbtnNorthEast.fill = GridBagConstraints.BOTH;
        gbc_rdbtnNorthEast.insets = new Insets(0, 0, 5, 5);
        gbc_rdbtnNorthEast.gridx = 0;
        gbc_rdbtnNorthEast.gridy = 0;
        panel.add(rdbtnNorthEast, gbc_rdbtnNorthEast);
        this.radioGroup.add(rdbtnNorthEast);

        rdbtnNorthWest = new JRadioButton("");
        GridBagConstraints gbc_rdbtnNorthWest = new GridBagConstraints();
        gbc_rdbtnNorthWest.fill = GridBagConstraints.BOTH;
        gbc_rdbtnNorthWest.insets = new Insets(0, 0, 5, 0);
        gbc_rdbtnNorthWest.gridx = 1;
        gbc_rdbtnNorthWest.gridy = 0;
        panel.add(rdbtnNorthWest, gbc_rdbtnNorthWest);
        this.radioGroup.add(rdbtnNorthWest);

        rdbtnSouthWest = new JRadioButton("");
        GridBagConstraints gbc_rdbtnSouthWest = new GridBagConstraints();
        gbc_rdbtnSouthWest.fill = GridBagConstraints.BOTH;
        gbc_rdbtnSouthWest.insets = new Insets(0, 0, 0, 5);
        gbc_rdbtnSouthWest.gridx = 0;
        gbc_rdbtnSouthWest.gridy = 1;
        panel.add(rdbtnSouthWest, gbc_rdbtnSouthWest);
        this.radioGroup.add(rdbtnSouthWest);

        rdbtnSouthEast = new JRadioButton("");
        GridBagConstraints gbc_rdbtnSouthEast = new GridBagConstraints();
        gbc_rdbtnSouthEast.fill = GridBagConstraints.BOTH;
        gbc_rdbtnSouthEast.gridx = 1;
        gbc_rdbtnSouthEast.gridy = 1;
        panel.add(rdbtnSouthEast, gbc_rdbtnSouthEast);
        rdbtnSouthEast.setSelected(true);
        this.radioGroup.add(rdbtnSouthEast);
    }

    public AnchorChangeListener getAnchorListener() {
        return anchorListener;
    }

    public void setAnchorListener(AnchorChangeListener anchorListener) {
        this.anchorListener = anchorListener;
    }


    @Override
    public void itemStateChanged(ItemEvent arg0) {
        OverlayAnchor newAnchor;
        if(arg0.getSource() == this.rdbtnNorthEast){
            newAnchor = OverlayAnchor.NORTHEAST;
        } else if(arg0.getSource() == this.rdbtnNorthWest) {
            newAnchor = OverlayAnchor.NORTHWEST;
        } else if(arg0.getSource() == this.rdbtnSouthEast) {
            newAnchor = OverlayAnchor.SOUTHEAST;
        } else {
            newAnchor = OverlayAnchor.SOUTHWEST;
        }
        if(this.anchorListener !=null) {
            this.anchorListener.anchorChanged(new AnchorChangeEvent(this, newAnchor));
        }
    }

    public Dimension getPreferredSize() {
        return this.getMinimumSize();
    }

    public Dimension getMaximumSize() {
        return this.getMinimumSize();
    }
}