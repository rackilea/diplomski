object Fizz {
  private case object SendToBuzz
}

class Fizz(buzz: ActorRef) extends Actor with Timers {
  import Fizz._

  def receive = {
    case StartNewTimerTask =>
      val uuid = java.util.UUID.randomUUID
      timers.startPeriodicTimer(uuid, SendToBuzz, 8.seconds)
    case ResetAllTimerTasks =>
      timers.cancelAll()
    case SendToBuzz =>
      buzz ! DoItNow
  }
}