implicit class MyInt(val underlying: Int) extends AnyVal {
  def inc: Int = underlying + 1
}

implicit class MyString(val underlying: String) extends AnyVal {
  def firstChar: Char = underlying.charAt(0)
}

implicit class MyNonValueClassString(val underlying: String) {
  def firstCharNonValueClass: Char = underlying.charAt(0)
}