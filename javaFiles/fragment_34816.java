boolean isWeightUnit(String check, boolean customary) {
    String[] customaryUnits = {"lb","oz","T"};
    String[] metricUnits = {"kg"}; //I'm sorry that's all I know :(
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