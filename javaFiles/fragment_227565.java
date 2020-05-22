class BisReader(bis: BufferedInputStream) {
  val buffer = new Array[Byte](100000)
  var n = 0
  var i = 0
  def hasNext: Boolean = (i < n) || (n >= 0 && {
    n = bis.read(buffer)
    i = 0
    hasNext
  })
  def next: Byte = {
    if (i < n) {
      val b = buffer(i)
      i += 1
      b
    }
    else if (hasNext) next
    else throw new IOException("Input stream empty")
  }
}
implicit def reader_as_iterator(br: BisReader) = new Iterator[Byte] {
  def hasNext = br.hasNext
  def next = br.next
}