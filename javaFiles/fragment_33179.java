case class User(id: Option[Long], name: Option[String], date: Option[Date])
object User {
  def apply(id: Option[Long], name: Option[String]) = {
    User(id, name, None)
  }
}