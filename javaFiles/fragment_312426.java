object Hex {

  def valueOf(buf: Array[Byte]): String = buf.map("%02X" format _).mkString

  def valueOf(o: Byteable): String = valueOf(o.toByteArray)

}