/**
 * Sets up the autocomplete fragment to show place details when a place is selected.
 */
private void setupAutoCompleteFragment() {
    PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
            getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);

    AutocompleteFilter typeFilter = new AutocompleteFilter.Builder()
            .setTypeFilter(Place.TYPE_COUNTRY).setCountry("IN")

            .build();
    autocompleteFragment.setFilter(typeFilter);

    autocompleteFragment.setHint(getResources().getString(R.string.search_stadium_court_area));
    autocompleteFragment.searchIcon.setVisibility(View.GONE);
    autocompleteFragment.input.setTextSize(10f);

    autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {


        @Override
        public void onPlaceSelected(Place place) {
            showPlace(getString(R.string.place_autocomplete_search_hint), place);

        }

        @Override
        public void onError(Status status) {
            showResponse("An error occurred: " + status);
        }
    });
}


    private void showPlace(String source, Place place) {
    locationSelect = AppConstants.LOCATION_SELECTED_ONITEMCLICK;

    PlaceBean placeBean = new PlaceBean();


    placeBean.setAddress(String.valueOf(place.getAddress()));
    placeBean.setLatitude(String.valueOf(place.getLatLng().latitude));
    placeBean.setLongitude(String.valueOf(place.getLatLng().longitude));
    placeBean.setName((String) place.getName());
    placeBean.setCityname(cityName);

    Intent intent = new Intent();
    intent.putExtra("location", placeBean);
    setResult(RESULT_OK, intent);
    finish();

}