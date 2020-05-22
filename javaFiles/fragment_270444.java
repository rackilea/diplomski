public void onClick(View view) {
    switch (view.getId()) {
        case R.id.SearchButton:
            MainActivity activity = (MainActivity) getActivity();
            if (activity != null) {
                activity.openMapFragment();
            }
            break;
    }
}