stationsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int stationID = stations.get(position).getId();

        Intent intent = new Intent(ShowStations.this, ShowStationList.class);
        intent.putExtra("station_id",stationID);
        startActivity(intent);
    }
});