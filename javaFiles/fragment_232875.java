public class DualTableFrame extends JFrame {

    private JTable leftTable;
    private JTable rightTable;
    private JButton addButton;
    private JButton removeButton;

    public DualTableFrame() {

        setTitle("Dual wielding tables");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());

        leftTable = new JTable(new SimpleColorTableModel());
        rightTable = new JTable(new SimpleColorTableModel());

        setupTable(leftTable);
        setupTable(rightTable);

        populate((SimpleColorTableModel) leftTable.getModel());

        addButton = new JButton("Add >>");
        removeButton = new JButton("<< Remove");

        JPanel pnlActions = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlActions.add(addButton, gbc);

        gbc.gridy++;
        pnlActions.add(removeButton, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.33;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        add(new JLabel("Available Choices"), gbc);
        gbc.gridx++;
        add(new JPanel(), gbc);
        gbc.gridx++;
        add(new JLabel("Your Choices"), gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.weighty++;
        gbc.fill = GridBagConstraints.BOTH;

        add(new JScrollPane(leftTable), gbc);
        gbc.gridx++;
        add(pnlActions, gbc);
        gbc.gridx++;
        add(new JScrollPane(rightTable), gbc);

        setSize(400, 600);

        addButton.setEnabled(false);
        removeButton.setEnabled(false);

        leftTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                int count = leftTable.getSelectedRowCount();
                addButton.setEnabled(count > 0);

            }
        });
        rightTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                int count = rightTable.getSelectedRowCount();
                removeButton.setEnabled(count > 0);

            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                moveSelectedRow(leftTable, rightTable);

            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                moveSelectedRow(rightTable, leftTable);

            }
        });

    }

    protected void moveSelectedRow(JTable from, JTable to) {

        SimpleColorTableModel fromModel = (SimpleColorTableModel) from.getModel();
        SimpleColorTableModel toModel = (SimpleColorTableModel) to.getModel();

        for (int index : from.getSelectedRows()) {

            Vector rowValue = (Vector) fromModel.getDataVector().get(index);

            toModel.addRow(rowValue);

        }

        int selectedRow = -1;
        while ((selectedRow = from.getSelectedRow()) != -1) {

            fromModel.removeRow(selectedRow);

        }

        from.clearSelection();

    }

    protected void populate(SimpleColorTableModel model) {

        model.addRow(new Object[]{"Black", Color.BLACK});
        model.addRow(new Object[]{"Blue", Color.BLUE});
        model.addRow(new Object[]{"Cyan", Color.CYAN});
        model.addRow(new Object[]{"Dark Gray", Color.DARK_GRAY});
        model.addRow(new Object[]{"Gray", Color.GRAY});
        model.addRow(new Object[]{"Green", Color.GREEN});
        model.addRow(new Object[]{"Light Gary", Color.LIGHT_GRAY});
        model.addRow(new Object[]{"Mangenta", Color.MAGENTA});
        model.addRow(new Object[]{"Orange", Color.ORANGE});
        model.addRow(new Object[]{"Pink", Color.PINK});
        model.addRow(new Object[]{"Red", Color.RED});
        model.addRow(new Object[]{"White", Color.WHITE});
        model.addRow(new Object[]{"Yellow", Color.YELLOW});

    }

    protected void setupTable(JTable table) {

        table.setFillsViewportHeight(true);

        table.setDefaultRenderer(Color.class, new ColorTableCellRenderer());

    }
}