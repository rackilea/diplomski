Intent openGetData = new Intent(SearchDatabase.this, GetData.class);
openGetData.putExtra("Venue_Name", VenueName);
openGetData.putExtra("Event_Name", EventName);
openGetData.putExtra("Category", Category);
openGetData.putExtra("Region", Region);
startActivity(openGetData);