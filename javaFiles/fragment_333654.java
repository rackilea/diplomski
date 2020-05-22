import scala.reflect.ClassTag

object Types {
  trait DataType[A] {
    // more stuff
  }

  object IntType extends DataType[Int]

  object StringType extends DataType[String]

  trait Codec[B] {
    val dtype: DataType[B]
    // more stuff
  }

  class DenseCodec[B](val dtype: DataType[B]) extends Codec[B] {
    def get(size: Int)(implicit ct: ClassTag[B]) = new Array[B](size)
  }

  def main(args: Array[String]): Unit = {
    val denseInt = new DenseCodec(IntType)
    val arrInt = denseInt.get(4) //Array[Int]

    val denseString = new DenseCodec(StringType)
    val arrString = denseString.get(4) //Array[String]
  }
}