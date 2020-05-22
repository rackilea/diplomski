class MyDataset extends XYSeriesCollection implements TableModelListener {

    @Override
    public void tableChanged(TableModelEvent e) {
        // update dataset to fireDatasetChanged();
    }
}