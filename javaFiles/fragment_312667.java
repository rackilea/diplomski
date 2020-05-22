// Create a collection of String any way you like, but for testing
// I've simply split a flat string into an array.
String flatString = "A_2007-04,A_2007-09,A_Agent,A_Daily,A_Execute,A_Exec,"
        + "P_Action,P_HealthCheck";
String[] reports = flatString.split(",");

Map<String, List<String>> mapFromReportKeyToValues = new HashMap<>();

for (String report : reports) {
    int underscoreIndex = report.indexOf("_");
    String key = report.substring(0, underscoreIndex);
    String newValue = report.substring(underscoreIndex + 1);
    List<String> existingValues = mapFromReportKeyToValues.get(key);
    if (existingValues == null) {
        // This key hasn't been seen before, so create a new list
        // to contain values which belong under this key.
        existingValues = new ArrayList<>();
        mapFromReportKeyToValues.put(key, existingValues);
    }
    existingValues.add(newValue);
}

System.out.println("Generated map:\n" + mapFromReportKeyToValues);