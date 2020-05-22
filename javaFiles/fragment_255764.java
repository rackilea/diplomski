class Rts(buffer: Iterator[Tse]) extends Ts {
  // overloaded constructor that can be used from Java
  def this(buffer: java.util.Iterator[Tse]) = this({
    import scala.collection.JavaConverters._
    buffer.asScala
  })
}