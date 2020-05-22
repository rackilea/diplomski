object password {
  import scala.util.Random
  import scala.collection.immutable.Stream


  private def gen = Random.alphanumeric

  def get(len: Int): String = {    
    def build(acc: String, s: Stream[Char]): String = {
      if (s.isEmpty) acc
      else build(acc + s.head, s.tail)
    }

    build("", gen take len)
  }
}