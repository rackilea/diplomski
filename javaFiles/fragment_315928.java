@Override
public void onResume() {
    super.onResume();
    locationListeners.add(WeatherDBAccess.Instance());
}

@Override
public void onPause() {
    super.onPause();
    locationListeners.remove(WeatherDBAccess.Instance());
}