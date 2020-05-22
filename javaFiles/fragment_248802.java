class G implements Runnable {
  void run() { println 'Groovy!' }
}

g1 = new G()
g.run()
g1.run()