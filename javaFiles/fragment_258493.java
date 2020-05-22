trait IntervalUpdate {

  val updateInterval: Long

  def onUpdateTask:() => Unit

  val timer: Timer = new Timer()


  val timerTask = new TimerTask {
    override def run(): Unit =  onUpdateTask()
  }

  timer.scheduleAtFixedRate(timerTask, updateInterval, updateInterval)
}