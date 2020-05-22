import akka.http.javadsl.server.directives.RouteAdapter
import akka.http.scaladsl.server.{Route => ScalaRoute}
import akka.http.javadsl.server.{Route => JavaRoute}

object RouteConversions {
  def toJavaRoute(s:ScalaRoute):JavaRoute = RouteAdapter(s)
}