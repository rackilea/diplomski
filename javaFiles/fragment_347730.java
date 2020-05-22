private static final DefaultPieDataset dataset = createDataset();
…
public PieChartDemo1(String title) {
    super(title);
    add(createDemoPanel());
    add(new JButton(new AbstractAction("Update") {

        @Override
        public void actionPerformed(ActionEvent e) {
            dataset.setValue("Apple", dataset.getValue("Apple").doubleValue() + 1);
        }
    }), BorderLayout.SOUTH);
}