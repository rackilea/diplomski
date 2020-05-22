XYDataset data = createDataset();
XYItemRenderer renderer = new StandardXYItemRenderer() {

    @Override
    public Paint getItemPaint(int series, int item) {
        double value = data.getYValue(series, item);
        return …;
    }
};