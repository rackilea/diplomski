final String lat = restaurant.getLat();
final String lon = restaurant.getLon();

 FloatingActionButton fabGoToMap = findViewById(R.id.fabGoToMap);
    fabGoToMap.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("lat", lat);
            bundle.putString("lon", lon);
            intent.putExtras(bundle);
            setResult(Activity.RESULT_OK,intent);
        }
    });