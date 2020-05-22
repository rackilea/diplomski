protected void onCreate(Bundle savedInstanceState) {
     ...
            for (int i = 0; i < newLat.size(); i++) {
                DetailsPojo detailsPojo = new DetailsPojo(); //changes here
                latitudee = newLat.get(i);
                longitudee = newLong.get(i);
                dateetime = newDateTime.get(i);
                Log.e("detais  latitude", "" + latitudee);
                Log.e("detailos  longitudee", "" + longitudee);
                Log.e("detailos  datetimeee", "" + dateetime);
                detailsPojo.setDetailsdatetime(dateetime);
                detailsPojo.setDetailslat(latitudee);
                detailsPojo.setDetailslong(longitudee);
                details.add(detailsPojo); // and here
            }
            detList = (ListView) findViewById(R.id.detailsList);
            adapter = new DetailsAdapter(DetailsActivity.this, details);
            detList.setAdapter(adapter);
     }