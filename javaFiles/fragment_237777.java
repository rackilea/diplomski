JPanel panel = new JPanel(new MigLayout("insets 0, wrap 1", "[grow]"));
    JPanel listsPanel = new JPanel(new MigLayout("insets 0, wrap 1",
            "[grow]", "[]0[5:5:5]0[]"));
    JLabel separatorLabel = new JLabel("_");
    separatorLabel.setBorder(new LineBorder(Color.BLACK, 300));

    JTable upper = new JTable(20, 3);
    JTable lower = new JTable(20, 3);
    // enable drag in upper
    upper.setDragEnabled(true);
    TransferHandler tableTransfer = new TransferHandler() {
        @Override
        public boolean canImport(JComponent comp,
                DataFlavor[] transferFlavors) {
            return true;
        }
    };
    lower.setTransferHandler(tableTransfer);

    listsPanel.add(upper, "growx");
    listsPanel.add(separatorLabel, "growx");
    listsPanel.add(lower, "growx");
    panel.add(listsPanel, "growx");
    JScrollPane pane = new JScrollPane(panel);