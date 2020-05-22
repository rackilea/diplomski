class Lock {
  List locks

  def lock() {
    locks.*lock()
  }

  // this method allows for calls like lock1[42].lock()
  def getAt( int ix ) { 
    locks[ ix ] 
  } 
}