class JavaInterfaceTest extends FlatSpec with Matchers with MockFactory {
  behavior of "scalamock"

  class StringInterface extends GOInterface[String] {
    override def send(record: String): Unit = ()

    override def send(record: String, onComplete: Callable[String]): Unit = ()
  }

  val call: (String, Callable[String]) => Unit = { case(s: String, c: Callable[String]) => c.call()}

  it should "mock java generic interface with overloaded method (with different number of parameters)" in {
    var result = ""
    val m = mock[StringInterface]
    (m.send(_: String, _: Callable[String])).expects(*, *)
      .onCall{ call }.once

    m.send("hello", new Callable[String] {
      override def call(): String = {result = "world"; result}
    })

    result should be("world")
  }


  it should "mock java generic interface with overloaded method (with different number of parameters) 2" in {
    var result = ""
    val m = mock[StringInterface]
    (m.send(_: String)).expects(*).once

    m.send("hello")

    result should be("")
  }
}