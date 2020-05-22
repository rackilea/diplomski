SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
SharedPreferences.Editor editor = sharedPref.edit();
editor.putInt(getString(R.string.points), pointsPerActivity);
editor.commit();

SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
int defaultValue = 1;
// or you can store the value somewhere
// getResources().getInteger(R.integer.defaultPointsPerActivity);
int pointsPerActivity = sharedPref.getInt(pointsPerActivity, defaultValue);