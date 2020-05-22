@Override
    public void onMapReady(GoogleMap map) {

        mapVar = map;
        // MapWrapperLayout initialization


       CameraPosition googlePlex = CameraPosition.builder()
                .target(new LatLng(latitude, longitude))
                .zoom(15)
                .bearing(0)
                .tilt(45)
                .build();
        map.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 2000, null);


        final MapWrapperLayout mapWrapperLayout = (MapWrapperLayout) findViewById(R.id.map_relative_layout);
        // MapWrapperLayout initialization

        mapWrapperLayout.init(map, getPixelsFromDp(this, 39 + 20));
        this.infoWindow = (ViewGroup) getLayoutInflater().inflate(R.layout.info_window, null);
        this.infoTitle = (TextView) infoWindow.findViewById(R.id.title);
        this.infoSnippet = (TextView) infoWindow.findViewById(R.id.snippet);
        this.infoButton = (Button) infoWindow.findViewById(R.id.button);

        // Setting custom OnTouchListener which deals with the pressed state
        // so it shows up
        this.infoButtonListener = new OnInfoWindowElemTouchListener(infoButton,
                getResources().getDrawable(R.drawable.round_but_green_sel), //btn_default_normal_holo_light
                getResources().getDrawable(R.drawable.round_but_red_sel)) //btn_default_pressed_holo_light
        {


            @Override
            protected void onClickConfirmed(View v, Marker marker) {


                // Here we can perform some action triggered after clicking the button
                //Toast.makeText(MainActivity.this, marker.getTitle() + "'s button clicked!", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(MainActivity.this, dettaglio.class);
                //EditText editText = (EditText) findViewById(R.id.edit_message);
                String titolo = marker.getTitle();
                String idPOI = allMarkersMapIds.get(marker);
                String IMGPOI = allMarkersMapImg.get(marker);
                String Desc = allMarkersMapDesc.get(marker);
                String  idUtentePOI = allMarkersMapidUtente.get(marker);
                String  idCategoria = allMarkersMapidCategoria.get(marker);

                LATLON = marker.getPosition();
                Bundle args = new Bundle();
                args.putParcelable("coordinatePOI", LATLON);
                intent.putExtra("bundle", args);

                intent.putExtra(EXTRA_MESSAGE, titolo);
                intent.putExtra(EXTRA_ID, idPOI);
                intent.putExtra(EXTRA_IMG, IMGPOI);
                intent.putExtra(EXTRA_Desc, Desc);
                intent.putExtra("IDCATEGORIAPOI", idCategoria);
                intent.putExtra("IDUTENTEPOI", idUtentePOI);


                startActivity(intent);

            }
        };
        this.infoButton.setOnTouchListener(infoButtonListener);


        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                // Setting up the infoWindow with current's marker info
                infoTitle.setText(marker.getTitle());
                infoSnippet.setText(marker.getSnippet());
                infoButtonListener.setMarker(marker);

                // We must call this to set the current marker and infoWindow references
                // to the MapWrapperLayout
                mapWrapperLayout.setMarkerWithInfoWindow(marker, infoWindow);
                return infoWindow;
            }
        });



        setUpMapIfNeeded(0, ricercaString);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

map.setMyLocationEnabled(true);

    }