boolean isDistanceUnit(String check, boolean customary) {
    String[] customaryUnits = {"mi","yd","ft","in"};
    String[] metricUnits = {"mm","cm","dm","m","km"};
    if (customary) {
        for (int i = 0; i <= customaryUnits.length; i++) {
            if (check.toLowerCase().contains(customaryUnits[i])) {
                return true;
            }
        }
        return false;
    } else {
        for (int i = 0; i <= metricUnits.length; i++) {
            if (check.toLowerCase().contains(metricUnits[i])) {
                return true;
            }
        }
        return false;
    }
}