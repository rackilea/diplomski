if (!hashMap.containsKey(string.toLowerCase()){
     Vector v = new Vector();
     v.add(string);
      hashMap.put(string.toLowerCase(), v);
} else { 
     hashMap.get(string.toLowerCase()).add(string);
}