class HString(hash: Int, string: String){
  def getHash = hash
  def getString = string
  override def equals(otherHString: Any): Boolean = {
    otherHString match {
      case other: HString => (hash == other.getHash) && (string == other.getString)
      case _ => false
    }
  }
  override def hashCode = hash
}