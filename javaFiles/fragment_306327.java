setLayout(new BorderLayout());

    JPanel gridBagWrap = new JPanel();

    GridBagLayout gbl_panel = new GridBagLayout();
    gbl_panel.columnWidths = new int[] { 86, 0 };
    gbl_panel.rowHeights = new int[] {32, 32, 32, 32, 32, 32, 32, 32, 32 };
    gbl_panel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
    gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
    gridBagWrap.setLayout(gbl_panel);

    JLabel lblEnterTrunkId = new JLabel("Enter Trunk ID");
    GridBagConstraints gbc_lblEnterTrunkId = new GridBagConstraints();
    gbc_lblEnterTrunkId.fill = GridBagConstraints.HORIZONTAL;
    gbc_lblEnterTrunkId.insets = new Insets(0, 0, 5, 0);
    gbc_lblEnterTrunkId.gridx = 0;
    gbc_lblEnterTrunkId.gridy = 0;
    gbc_lblEnterTrunkId.anchor = GridBagConstraints.NORTH;
    gridBagWrap.add(lblEnterTrunkId, gbc_lblEnterTrunkId);

    add(gridBagWrap, BorderLayout.NORTH);