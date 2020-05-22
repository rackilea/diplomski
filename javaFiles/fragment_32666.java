class Walker {
  private var pos = 0

  def state = new Walker.State(pos)
  def state_= (s: Walker.State) {
    pos = s.pos
  }
}
object Walker {
  class State (private[Walker] val pos: Int)
}

val w1 = new Walker                               //> w1  : demos.Walker = demos$Walker@4fccd51b
val w2 = new Walker                               //> w2  : demos.Walker = demos$Walker@475530b9
w1.state = w2.state