case class PostalCode(value: String)
case object PostalCode {
  def parse(s: String): Option[PostalCode] = try {
    Some(PostalCode(someThrowingLogic(s)))
  }
  catch {
    case e: Exception => None
  }
  def clean(s: String): PostalCode = PostalCode(s.replaceAll(" ","").toUpperCase)
}