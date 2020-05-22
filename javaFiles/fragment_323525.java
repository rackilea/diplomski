private void setupAutoCompleteFragment(OnMapReadyCallback instance) {

        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)getActivity().
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                mapview.getMapAsync(instance);
            }

            @Override
            public void onError(Status status) {
                Log.e("Error", status.getStatusMessage());
            }
        });
    }