HashMap<Integer, DateTileGrid>  dataGridMap = new HashMap<>();
for (Date date: dateList) {
    int year = date.getYear(); //Deprecated.. use something better
    DateTileGrid dataGrid = dataGridMap.get(year);
    if(dataGrid == null){
        dataGrid = new DateTileGrid();
        dataGrid.setCurrentYear(year);
        dataGrid.setDateTiles(new ArrayList<Date>());
        dataGridMap.put(year, dataGrid);
    }
    dataGrid.getDateTiles().add(date);
}
//Here is your result
ArrayList<DateTileGrid> result = new ArrayList<>(dataGridMap.values());