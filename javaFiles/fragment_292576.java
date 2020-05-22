// Here is the immutable class
case class Person( name: String, age: Int, married: Boolean )

// Here comes the mutable builder
class PersonBuilder {
  private var name: Option[String] = None
  private var age: Option[Int] = None
  private var married: Option[Boolean] = None

  def setName( n: String ) = { name = Some(n); this }
  def setAge( a: Int ) = { age = Some(a); this }
  def setMarried( m: Boolean ) = { married = Some(m); this }

  def build() = {
    val person = for( n <- name; a <- age; m <- married ) 
                   yield { Person( n, a, m ) }
    person getOrElse { throw new IllegalStateException( /*msg*/ ) }
  }
}