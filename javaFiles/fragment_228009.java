DatabaseReference routeRef = dataMarker.child("LRP")
                    .child(userId);

            routeRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot ss : dataSnapshot.getChildren()) {
                            for (DataSnapshot datas : ss.child("route_models").getChildren()) {
                            double latitude = datas.child("rtLat").getValue(Double.class);
                            double longitude = datas.child("rtLng").getValue(Double.class);
                            LatLng loc = new LatLng(latitude, longitude);
                            mMap.addMarker(new MarkerOptions().position(loc).title("test")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ic_action_pole));
                          }
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });