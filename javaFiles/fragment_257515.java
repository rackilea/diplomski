trait Greetings {
  def hello() { println("hello") }
  def bye() { println("bye") }
}

object FrenchGreetings extends Greetings {
  override def hello() { println("bonjour") }
  override def bye() { println("au revoir") }
}

def doSomething( greetings: Greetings ) {
  greetings.hello()
  println("... doing some work ...")
  greetings.bye()
}

doSomething( FrenchGreetings )