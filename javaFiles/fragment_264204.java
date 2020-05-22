//final JButton jButton = new JButton();

        jTable.setDefaultRenderer(String.class, new DefaultTableCellRenderer() {
           private final JButton jButton = new JButton();
        // rest of renderer

        jTable.setDefaultEditor(String.class, new DefaultCellEditor(new JCheckBox()) { // JCheckBox is closest to a button...
           private final JButton jButton = new JButton();
        // rest of editor