@Override
public View getInfoWindow(Marker marker) {
    if (mLastMarker != null) {
        // Stop task for mLastMarker
    }

    Log.e(TAG, "Info window requested for " + marker);
    mLastMarker = marker;
    return null; // Returning null will load the default InfoWindow
}