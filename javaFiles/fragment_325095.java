Location bestResult = null;
    float bestAccuracy = Float.MAX_VALUE;
    long bestAge = Long.MIN_VALUE;
    List<String> matchingProviders = mLocationManager.getAllProviders();

    for (String provider : matchingProviders) {

        Location location = mLocationManager.getLastKnownLocation(provider);

        if (location != null) {

            float accuracy = location.getAccuracy();
            long time = location.getTime();

            if (accuracy < bestAccuracy) {

                bestResult = location;
                bestAccuracy = accuracy;
                bestAge = time;

            }
        }
    }

    // Return best reading or null
    if (bestAccuracy > minAccuracy
            || (System.currentTimeMillis() - bestAge) > maxAge) {
        return null;
    } else {
        return bestResult;
    }