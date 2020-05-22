trait Paper[M] {
  def paint(args: M): Unit
}

class WhitePaper extends Paper[DarkMaterial] {
  override def paint(args: DarkMaterial): Unit = { // "override" not needed
    args.open()
  }
}
// Material and DarkMaterial are unchanged