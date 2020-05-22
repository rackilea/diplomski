import org.scalatest.FlatSpec

class MainSpec extends FlatSpec {

  "Main" should "enter the debug loop if args contain 'debug'" in {
    val program: IO[RunResult] = Main.run0("debug" :: Nil)
    program.unsafeRunSync() match {
      case Debug => // do stuff
      case Run => // other stuff
    }
  }
}