import annotation.meta._

object Helper {
  type Whenfield = When @field
}
import Helper._

case class TestScalaClass(@Whenfield(event = "something") someField: String)