for(int i = 0, i < camerasLocations.size(), i++){

                                Marker marker = googleMap.addMarker(new MarkerOptions()
                                .position(location).icon(icon)
                                .title(cameraList.get(j).getName()))
                                .setTag(i);
                            }

And then you can obtain this marker position in the onclick method using getTag() method : 




googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {

                    Toast.makeText(this, "Marker position >> " + marker.getTag(), Toast.LENGTH_SHORT).show();
                    return false;
                }
            });