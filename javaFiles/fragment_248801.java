class G implements Runnable {
  void run() { println 'Groovy' }
}

g = new G()
g.run()