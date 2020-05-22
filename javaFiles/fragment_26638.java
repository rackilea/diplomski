Map<String, String> theMap = new HashMap<>();
String[] pairs = testString.split(",");
for (String pair : pairs) {
    String[] parts = pair.replaceAll("\"", "").split(":");
    theMap.put(parts[0], parts[1]);
}

System.out.println(theMap.get("application_id"));