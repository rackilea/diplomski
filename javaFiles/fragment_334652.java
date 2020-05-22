// treemap is sorted by the keys. Supplementary, you can use your own
// comparator for a custom order
TreeMap<Integer, Integer> valuesToIndexes=
   new TreeMap<>(new Comparator<Integer>() {
     public int compare(Integer a, Integer b) {
       return b-a; // in the inverse order
     }
   })
;
for(int i=0; i<arr.length; i++) {
  valuesToIndexes.put(arr[i], i);
}
// iterating the values of a map will be done in the order of the map's keys
// Since the key is the array value in reverse (and the value is the index)
// we'll be outputting the array indexes in the decreasing order of its values
for(Integer v : valuesToIndexes.values()) {
  System.out.println(v);
}