Location bestResult = null;
float bestAccuracy = Float.MAX_VALUE;
long bestTime = Long.MIN_VALUE;

// Iterate through all the providers on the system, keeping
// note of the most accurate result within the acceptable time limit.
// If no result is found within maxTime, return the newest Location.
List<String> matchingProviders = locationManager.getAllProviders();
for (String provider: matchingProviders) {
  Location location = locationManager.getLastKnownLocation(provider);
  if (location != null) {
    float accuracy = location.getAccuracy();
    long time = location.getTime();

    if ((time > minTime && accuracy < bestAccuracy)) {
      bestResult = location;
      bestAccuracy = accuracy;
      bestTime = time;
    }
    else if (time < minTime && bestAccuracy == Float.MAX_VALUE && time > bestTime) {
      bestResult = location;
      bestTime = time;
    }
  }
}