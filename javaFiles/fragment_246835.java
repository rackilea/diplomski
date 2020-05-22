private XYDataset createDataset() {
        XYSeries s1 = new XYSeries("S1");
        s1.add(0, 0);
        s1.add(1, 2);
        s1.add(2, 5);
        s1.add(3, 10);
        s1.add(4, 7);
        s1.add(5, 8);
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(s1);
        return dataset;
   }