object Example {
  import scala.collection.jcl

  // Build the example data structure
  val row1 = new java.util.ArrayList[Double]()
  val row2 = new java.util.ArrayList[Double]()
  val mat = new java.util.ArrayList[java.util.ArrayList[Double]]()
  row1.add(1.0) ; row1.add(2.0) ; row2.add(3.0) ; row2.add(4.0)
  mat.add(row1) ; mat.add(row2)
  val named = new java.util.HashMap[String,java.util.ArrayList[java.util.ArrayList[Double]]]
  named.put("matrix",mat)

  // This actually does the conversion
  def asScala(thing: java.util.HashMap[String,java.util.ArrayList[java.util.ArrayList[Double]]]) = {
    Map() ++ (new jcl.HashMap(thing)).map(kv => {
      ( kv._1 ,
        (new jcl.ArrayList(kv._2)).map(al => {
          (new jcl.ArrayList(al)).toArray
        }).toArray
      )
    })
  }
}