// in A
public Map<Integer, Integer> putIntoMap(int a[]){
  Map <Integer, Integer> intMapObject = // ...
  // some code to put the stuff in the map here

  return intMapObject;
}

// in B
A a = new A();
Map<Integer, Integer> theMap = a.putIntoMap(arr);
for(Map.Entry<Integer, Integer> e : theMap.entrySet()) {
    // some code here
}