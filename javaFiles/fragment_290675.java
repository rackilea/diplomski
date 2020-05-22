@Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            mMapView = mView.findViewById(R.id.map);
           //initialize before calling map onCreate
            MapsInitializer.initialize(getActivity());
            if (mMapView != null) {
                //instead of passing null its a good practice to use savedInstanceState
                mMapView.onCreate(savedInstanceState);
                mMapView.onResume();
                mMapView.getMapAsync(this);
            }
        }