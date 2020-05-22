// first time that a is "i"
Integer freq = m.get(a); // returns null because "i" is not in the map
m.put(a, (freq == null) ? 1 : freq + 1); // associates 1 to the key "i"

// second time that a is "i"
Integer freq = m.get(a); // returns 1 because "i" is associated with 1
m.put(a, (freq == null) ? 1 : freq + 1); // associates freq+1 (=2) to the key "i"

// second time that a is "i"
Integer freq = m.get(a); // returns 2 because "i" is associated with 2
m.put(a, (freq == null) ? 1 : freq + 1); // associates freq+1 (=3) to the key "i"