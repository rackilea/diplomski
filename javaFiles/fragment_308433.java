// Test map full of values...
Map<Integer, String> mapTest = new HashMap<>(25);
for (int index = 0; index < 10; index++) {
    mapTest.put(index, Integer.toString(index));
}

// Grab an iterator
Iterator<Map.Entry<Integer, String>> insurances = mapTest.entrySet().iterator();
// Create a temp map for the new values
Map<Integer, String> newValues = new HashMap<>(25);
while(insurances.hasNext()) {

    Map.Entry<Integer, String> entry = insurances.next();
    int key = entry.getKey();
    // Make the comparison about what we want to do, here
    // we're removing even keys
    if (key % 2 == 0) {
        // Remove the old entry
        insurances.remove();
        // Use the temp map to create a new entry
        newValues.put(key * 10, entry.getValue());
    }

}

// Merge the results
mapTest.putAll(newValues);