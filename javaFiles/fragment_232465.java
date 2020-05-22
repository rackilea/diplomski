import swing._

case class WindowStateChanged(
  override val source: Window,
  oldState: Int,
  newState: Int
) extends event.WindowEvent(source)

trait StateListeningWindow extends Window { outer =>
  this.peer.addWindowStateListener(new java.awt.event.WindowStateListener {
    def windowStateChanged(e: java.awt.event.WindowEvent) {
      publish(WindowStateChanged(outer, e.getOldState, e.getNewState))
    }
  })
}