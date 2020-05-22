import java.util
import scala.collection.JavaConverters._

def f(x: util.List[Int]): Array[Int] = {
  x.asScala.toArray[Int]
}