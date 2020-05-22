class EMCC(private val map: TreeMap[Long, HashSet[DSFrame]] = TreeMap.empty[Long, HashSet[DSFrame]]) {
  def insert(key: Long, value: HashSet[DSFrame]) = new EMCC(map + (key -> value))
  def foo = map.size
}
var e = new EMCC
e = e.insert(23L, HashSet.empty[DSFrame])
println(e.foo)