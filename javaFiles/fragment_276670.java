implicit object IntComp extends java.util.Comparator[Int] {
  def compare(a: Int, b: Int) = a.compareTo(b)
}

scala> ordered(1,2,3)
res5: Boolean = true

scala> ordered(1,3,2)
res6: Boolean = false