// store first map in (new) temporary map
HashMap<Integer, String> tempMap = new HashMap<Integer, String>(hm);

// clear first map and store pairs of hm2
hm.clear();
hm.putAll(hm2);

// clear second map and store pairs of tempMap
hm2.clear();
hm2.putAll(tempMap);

// EDIT (hint from Palcente)
// optional: null the tempMap afterwards
tempMap = null;