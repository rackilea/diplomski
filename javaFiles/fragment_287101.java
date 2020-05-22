trait T {
  type G
  def f: G
}

class C extends T {
  override type G = Int
  override def f = 42
}