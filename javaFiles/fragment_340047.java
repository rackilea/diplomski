import scala.util.{ Try, Success, Failure }

def getSomething(name: String): MyError \/ Option[Int] = {

   Try(queryDB(name)) match {
     case Success(v) => Option(v).right // in case v is null, this returns a None
     case Failure(e) => MyError().left
   }

}