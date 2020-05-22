import scala.collection.jcl.Conversions._

// adds a key/value pair and returns the new map (not!)
def process(map: Map[String, Int]) = {
  map.put("one", 1)
  map
}