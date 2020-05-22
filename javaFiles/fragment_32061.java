public void onModuleLoad() {
    DataSourceTextField continentField = new DataSourceTextField("continent");
    continentField.setPrimaryKey(true);

    DataSource dataSource = new DataSource();
    dataSource.setClientOnly(true);
    dataSource.setFields(continentField);
    for (CountryRecord record : new CountryData().getNewRecords()) {
        dataSource.addData(record);
    }

    ListGrid myGrid = new ListGrid();
    myGrid.setWidth(200);
    myGrid.setHeight(100);
    myGrid.setDataSource(dataSource);
    myGrid.fetchData();
    myGrid.draw();
}

class CountryData {

    public CountryRecord[] getNewRecords() {
        return new CountryRecord[] { 
                new CountryRecord("North America"), 
                new CountryRecord("Asia") };
    }
}

class CountryRecord extends ListGridRecord {
    public CountryRecord(String continent) {
        setContinent(continent);
    }

    public void setContinent(String continent) {
        setAttribute("continent", continent);
    }

    public String getContinent() {
        return getAttributeAsString("continent");
    }
}