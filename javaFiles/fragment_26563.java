val listeners = new ListBuffer[Int => Unit]

def registerListener(f: Int => Unit) {
  if (!listeners.contains(f)) {
    listeners.append(f)
  }
}