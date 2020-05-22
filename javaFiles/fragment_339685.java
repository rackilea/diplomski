private val receiver = actor {
    var done = false
    while (!done) {
      val n = in.read
      if(n < 0)
        done = true
      else
        handler(n.toChar)
    }
  }