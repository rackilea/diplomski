public class TestBusy {

    public static void main(String[] args) {
        new TestBusy();
    }

    public TestBusy() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new ContentPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ContentPane extends JPanel {

        private JTable table;

        public ContentPane() {
            setLayout(new BorderLayout());
            table = new JTable();
            table.setFillsViewportHeight(true);

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("One");
            model.addColumn("Two");
            model.addColumn("Three");
            model.addColumn("Four");
            model.addColumn("Five");
            model.addColumn("Six");
            model.addColumn("Seven");
            table.setModel(model);
            JScrollPane scrollPane = new JScrollPane(table);

            JBusyComponent<JScrollPane> busyComponent = new JBusyComponent<JScrollPane>(scrollPane);
            add(busyComponent);

            busyComponent.getBusyModel().setMinimum(0);
            busyComponent.getBusyModel().setMaximum(10000);

            busyComponent.setBusy(true);
            BusySwingWorker<Object, Object[]> worker = new BusySwingWorker<Object, Object[]>(busyComponent.getBusyModel()) {

                @Override
                protected void process(List<Object[]> chunks) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    for (Object[] chunk : chunks) {
                        model.addRow(chunk);
                    }
                }

                @Override
                protected Object doInBackground() throws Exception {
                    for (int index = 0; index < 1000; index++) {
                        setProgress(Math.round((index / 1000f) * 100f));
                        publish(new Object[]{index, "B", "C", "D", "E", "F", "G"});
                        Thread.sleep(5);
                    }
                    return null;
                }
            };
            worker.execute();
        }
    }
}