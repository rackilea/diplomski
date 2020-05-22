type EMCC = TreeMap[Long, HashSet[DSFrame]]
implicit class EmccExt(map: EMCC) {
  def foo = map.size
}
var e = new EMCC
e = e.insert(23L, HashSet.empty[DSFrame])
println(e.foo)