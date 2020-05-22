public class GUI extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    private final JButton button;
    private final JTable table;
    private final DefaultTableModel tableModel = new DefaultTableModel();

    public GUI() throws HeadlessException {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        button = new JButton("Load Data");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        loadData();
                        return null;
                    }
                }.execute();
            }
        });
        add(button, BorderLayout.PAGE_START);

        setSize(640, 480);
    }

    private void loadData() {
        LOG.info("START loadData method");

        button.setEnabled(false);

        try (Connection conn = DriverManager.getConnection(url, usr, pwd);
                Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("select * from customer");
            ResultSetMetaData metaData = rs.getMetaData();

            // Names of columns
            Vector<String> columnNames = new Vector<String>();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }

            // Data of the table
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int i = 1; i <= columnCount; i++) {
                    vector.add(rs.getObject(i));
                }
                data.add(vector);
            }

            tableModel.setDataVector(data, columnNames);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Exception in Load Data", e);
        }
        button.setEnabled(true);

        LOG.info("END loadData method");
    }

}