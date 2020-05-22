try {
        mLocationManager.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER,
                5 * 60 * 1000, //5 Minutes
                1F /*METERS*/,
                mLocationListeners[0]
        );
    } catch (java.lang.SecurityException ex) {
        Log.e(TAG, "failed to request location update. Insufficient permissions. ", ex);
        try {
            mLocationManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER,
                    5 * 60 * 1000, //5 Minutes
                    1F /*METERS*/,
                    mLocationListeners[1]
            );
        } catch (java.lang.SecurityException e) {
            Log.e(TAG, "failed to request location update. Insufficient permissions. ", e);
        } catch (IllegalArgumentException e) {
            Log.e(TAG, "Network provider does not exist.", e);
        }
    } catch (IllegalArgumentException ex) {
        Log.e(TAG, "Network provider does not exist.", ex);
    }
}