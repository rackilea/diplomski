object WindowStateDemo extends SimpleSwingApplication {
  def top = new MainFrame with StateListeningWindow {
    import java.awt.Frame._
    reactions += {
      case WindowStateChanged(_, _, ICONIFIED) => // Do something.
      case WindowStateChanged(_, oldState, newState) => // Something else.
    }
  }
}