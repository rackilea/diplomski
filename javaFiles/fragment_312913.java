ChartEntity ce = cme.getEntity();
if (ce instanceof XYItemEntity) {
    XYItemEntity e = (XYItemEntity) ce;
    XYDataset d = e.getDataset();
    int s = e.getSeriesIndex();
    int i = e.getItem();
    System.out.println("X:" + d.getX(s, i) + ", Y:" + d.getY(s, i));
}