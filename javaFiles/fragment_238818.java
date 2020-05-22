HashMap<String, String> m = new HashMap<>();
m.put("one", "1");

// Now "save" state and modify the map via a wrapper

Map<String, String> w = ...; // Create a wrapper

w.put("one", "2"); // This will trigger that map is modified
w.put("one", "1"); // This will trigger that map is modified, yet it is restored

// Now the contents of the map is identical to the state that was saved.