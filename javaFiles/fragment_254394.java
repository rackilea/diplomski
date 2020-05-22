@Override
public void actionPerformed(ActionEvent e) {
    XYSeries mySeries = myGraphPanel.myDataset.getSeries(0);
    mySeries.addOrUpdate(tempCtr, Math.pow(2, tempCtr));
    tempCtr++;
}