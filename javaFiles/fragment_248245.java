List<HashMap<String,String>> hashMaps = new ArrayList<HashMap<String,String>>();

List<Map<String,String>> maps = hashMaps; // Won't compile,
                                          // but imagine that it could

Map<String,String> aMap = Collections.singletonMap("foo","bar"); // Not a HashMap

maps.add( aMap ); // Perfectly legal (adding a Map to a List of Maps)

// But maps and hashMaps are the same object, so this should be the same as

hashMaps.add( aMap ); // Should be illegal (aMap is not a HashMap)