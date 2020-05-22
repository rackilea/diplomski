searchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    for(int i=0; i < nama.length; i++) {
                        if (nama[i].equals(et.getText.toString())) {
                          //Remove old marker
                            oldmarker.remover();
                            // now inflate new marker like this
                            myMap.addMarker(new MarkerOptions() .position(new LatLng(lat[i], lon[i])) .title(nama[i]) .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptor‌​Factory.HUE_BLUE)));‌

                            CameraPosition camPos = new CameraPosition.Builder()
                                    .target(new LatLng(lat[i],  lon[i]))
                                    .zoom(18)
                                    .build();
                            CameraUpdate camUpd3 = CameraUpdateFactory.newCameraPosition(camPos);
                            googleMap.animateCamera(camUpd3);

                            break;
                        }else
                        {
                            //NOt found any nama .
                        }
                    }


                    ​}

          });