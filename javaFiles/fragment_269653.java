String[] a = {"Tony", "33", "male", "New York"};

List<Map<String, String>> listOfMaps = ...;

boolean found = false;
for(final Map<String, String> map : listOfmaps) {
    if(a[0].equals(map.get("name"))
            && a[1].equals(map.get("age"))
            && a[2].equals(map.get("gender"))
            && a[3].equals(map.get("city"))) {
        found = true;
        break;
    }
}

if(!found) {
    // raise the alarm - nothing matched
}