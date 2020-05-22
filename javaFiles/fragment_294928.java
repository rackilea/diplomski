object TypeTags {
  val SeqInteger = typeTag[Seq[Integer]]
  ...
  // or 
  val Integer = typeTag[Integer]
  def Seq[A](implicit tt: TypeTag[A]) = typeTag[Seq[A]]
}