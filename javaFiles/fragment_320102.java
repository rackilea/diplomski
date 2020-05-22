// Assuming that key and value were read from your file, and that
// myMap is declared as "Map<String, Double>"
if (myMap.containsKey (key)) {
    double oldValue = myMap.get (key);
    value += oldValue;
}

myMap.put (key, value);