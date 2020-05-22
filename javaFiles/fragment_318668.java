trait PostalCode {
  def value: String
}
case object PostalCode {
  private case class PCImpl(value: String) extends PostalCode
  def apply(v: String): PostalCode = v.replaceAll(" ","") match {
    case s if s.length == 6 =>
      PCImpl(s.toUpperCase)
    case _ =>
      throw new IllegalArgumentException(v + " is not a valid postal code.")
}