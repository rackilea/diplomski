@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {

    if (requestCode == REQUEST_PLACE_PICKER) {

        if (resultCode == Activity.RESULT_OK) {

            final Place place = PlacePicker.getPlace(getActivity(), data);

            if (place.getPlaceTypes().get(0).intValue() == 0) {
                mLocationNameTextView.setText(place.getAddress().toString());
            } else {
                mLocationNameTextView.setText(place.getName(););
            }              
        }
    }

    super.onActivityResult(requestCode, resultCode, data);
}