private void createInduction() {
    for (String s : titles) {
        all.addSeries(new TimeSeries(s));
    }
    // while parsing the CSV file
    String zone = …;
    TimeSeries ts = all.getSeries(zone);
    // add data to this zone's series
}