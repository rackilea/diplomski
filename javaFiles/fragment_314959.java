import controllers.routes
import org.specs2.mutable.Specification
import play.test.Helpers._
import play.api.test._

class MyControllerSpec extends Specification {
  "My Controller" should {
    "respond with text/plain content type" in new WithApplication {
      val result = callAction(routes.ref.MyController.index(), fakeRequest())
      contentType(result) mustEqual "text/plain"
    }
  }
}