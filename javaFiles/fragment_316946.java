object Util {
  def toBigramsScala(str: String) = {
    val hash = scala.collection.mutable.Set.empty[String]
    var i: Int = 0
    while (i <  str.length - 1) {
      val x1 = str.charAt(i)
      val x2 = str.charAt(i + 1)
      val tmp = new StringBuilder().append(x1).append(x2).toString()
      hash.add(tmp)
      i += 1
    }
    hash
  }
}