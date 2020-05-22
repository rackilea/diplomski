implicit object StringComp extends java.util.Comparator[String] {
  def compare(a: String, b: String) = a.compareTo(b)
}

scala> ordered("fish","wish","dish")
res11: Boolean = false