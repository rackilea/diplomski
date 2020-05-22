object LazyCharHash{
  private val map = HashMap.empty[Char,Int]
  private val r = new Random
  def lHash(c: Char): Int = {
    val d = map.get(c)
    d match {
      case None => {
        map.put(c,r.nextInt)
        lHash(c)
      }
      case Some(v) => v
    }
  }
}