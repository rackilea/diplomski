LatLngBounds latLngBounds = new LatLngBounds.Builder()
                    .include(first marker position)
                    .include(second marker position)
                    .build();

CameraUpdateFactory.newLatLngBounds(latLngBounds, 10);