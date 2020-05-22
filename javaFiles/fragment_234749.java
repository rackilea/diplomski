@Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putParcelableArrayList(PARKING_LIST, mFragment.getParkings());
        savedInstanceState.putInt(CURRENT_FIRST_PARKING, mFragment.getCurrentFirstVisibleParking());
        savedInstanceState.putString(CURRENT_SEARCH_QUERY, mFilter.getCurrentQuery());
...
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        ArrayList<Parking> parkings = savedInstanceState.getParcelableArrayList(PARKING_LIST);
        mFragment.setParkings(parkings);
        int currentFirstVisibleItem = savedInstanceState.getInt(CURRENT_FIRST_PARKING);
        mFragment.setCurrentFirstVisibleParking(currentFirstVisibleItem);
        mFilter.setCurrentQuery(savedInstanceState.getString(CURRENT_SEARCH_QUERY));
   ...
    }