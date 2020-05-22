class MyMergeAwareHashMap<K,V> extends HashMap<K,V> {
    HashMap<K, V> mergeMap

    public MyMergeAwareHashMap(Map<K, V> mergeMap) {
      this.mergeMap = mergeMap
    }

    @Override
    public Object put(K key, V value) {
      super.put(key, value)
      mergeMap.put(key, value)
    }
}

HashMap<String, Integer> mergedMap = new HashMap<String, Integer>()
MyMergeAwareHashMap<String, Integer> map1 = new MyMergeAwareHashMap<String, Integer>(mergedMap)
MyMergeAwareHashMap<String, Integer> map2 = new MyMergeAwareHashMap<String, Integer>(mergedMap)


map1.put('A', 1)
map2.put('B', 2)

println(map1.get('A')) // => 1
println(map1.get('B')) // => null

println(map2.get('A')) // => null
println(map2.get('B')) // => 2

println(mergedMap.get('A')) // => 1
println(mergedMap.get('B')) // => 2