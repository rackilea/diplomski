DefaultCategoryDataset dcd = new DefaultCategoryDataset();
for (int i = 0; i < dataset1.getColumnCount(); i++) {
    dcd.addValue(dataset1.getValue(dataset1.getRowKey(0), dataset1.getColumnKey(i)),
        dataset1.getRowKey(0), dataset1.getColumnKey(i));
    dcd.addValue(dataset2.getValue(dataset2.getRowKey(0), dataset2.getColumnKey(i)),
        dataset2.getRowKey(0), dataset1.getColumnKey(i));
}
JFreeChart chart = ChartFactory.createLineChart(…, dcd, …);