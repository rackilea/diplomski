List<XYChart.Series> seriesList = new ArrayList<Series>
int randomCount = randomNumbers.nextInt(100);
for(int i=0;i<randomCount;i++){
   XYChart.Series series = new XYChart.Series();
   series.setName("series " + randomCount);
   seriesList.add(series);
}