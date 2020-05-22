layFlator = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);

    View popUp =  layFlator.inflate(R.layout.map_settings, null);

    popupWindow = new PopupWindow(popUp, 750, 680, true);
    popupWindow.setAnimationStyle(R.style.PopupAnimation);

    Button btnHybrid = (Button) popUp.findViewById(R.id.mapHybrid);
    btnHybrid.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            Log.d("hybrid", "called");
            popupWindow.dismiss();
        }
    });