routeRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (int counter =0; counter<dataSnapshot.getChildrenCount();counter++) {
                        for (DataSnapshot ss : dataSnapshot.child("route_models").getChildren()) {
                            double latitude = ss.child("rtLat").getValue(Double.class);
                            double longitude = ss.child("rtLng").getValue(Double.class);
                            LatLng loc = new LatLng(latitude, longitude);
                            mMap.addMarker(new MarkerOptions().position(loc).title("test")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ic_action_pole));
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });