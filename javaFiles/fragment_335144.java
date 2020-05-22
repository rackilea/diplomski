PolylineOptions rectOptions = new PolylineOptions().width(3).color(
                Color.RED);

        @Override
        public void onLocationChanged(Location location) {


            rectOptions.add(new LatLng(location.getLatitude(), location.getLongitude()));

             if (setIt == true){
                  mMap.addPolyline(rectOptions);
             }


        }