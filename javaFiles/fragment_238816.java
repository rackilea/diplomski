HashMap<String, String> m = new HashMap<>();
// Populate map...

// Save the state:
HashMap<String, String> saved = new HashMap<>(m);

// Clients might modify map here...

// Test if the map was modified:
boolean modified = saved.equals(m);