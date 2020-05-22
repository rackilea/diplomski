button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
    String lat1 = sLatitude1.getText().toString();
    // parse string to double
    lati1 = ParseDouble(lat1);
    String lon1 = sLongtiude1.getText().toString();
    longi1 = ParseDouble(lon1);
    String lat2 = dLatitude2.getText().toString();
    lati2 = ParseDouble(lat2);
    String lon2 = dLongtiude2.getText().toString();
    longi2 = ParseDouble(lon2);
            double xy1 = distanceBetween(new LatLng(lati1, longi1), new LatLng(lati2, longi2));
            String distanceis = fmt(xy1) + "meter";
            textView.setText(distanceis);
        }

    });