trait CallStrategy

object CallStrategy {
  case object CALL_INDEX extends CallStrategy
}

trait MyStrategy {
  def random(as: CallStrategy)
}

object MyStrategy extends MyStrategy {
  def random(as: CallStrategy) = {
    println(as)
  }
}