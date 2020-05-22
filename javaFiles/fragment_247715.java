int markersCount = 0;
            Query dbQuery = FirebaseDatabase.getInstance().getReference().child("diseaseReported").orderByChild("nameReportedAtReportedOn").equalTo(disease+location+txtDate.getText());
            dbQuery.addValueEventListener(new ValueEventListener(){
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    for(DataSnapshot dataSnapshot : snapshot.getChildren())
                    {
                        Log.d("v1", dataSnapshot.toString());
                        Map m = dataSnapshot.getValue(Map.class);
                        double lat = m.getLat();
                        double lng = m.getLng();
                        String reportedAt = m.getReportedAt();
                        String reportedOn = m.getReportedOn();
                        String name = m.getName();
                        String snippetText = "Reported on: " + reportedOn;
                        LatLng c = new LatLng(lat, lng);

                        mMap.addMarker(new MarkerOptions().position(c).title("Disease reported: " + name).snippet(snippetText).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                        markersCount++;
                    }
                    Log.i("Markers Count", "Total Markers="+markersCount);
                }
            });