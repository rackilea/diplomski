import org.mockito.{MockitoAnnotations, InjectMocks, Mock}
import org.scalatest.{FunSpec, BeforeAndAfter}
import org.scalatest.Matchers._
import org.mockito.Mockito._
import org.springframework.beans.factory.annotation.Autowired

class InjectMocksSpec extends FunSpec with BeforeAndAfter {

  @Mock
  var paramMock: MockedClass = null

  @InjectMocks
  var testClass = new TestClass()

  describe("InjectMocks") {
    it("should inject mock for Autowired field") {
      MockitoAnnotations.initMocks(this)

      when(paramMock.get).thenReturn("bar")

      testClass.test should be("bar")

      verify(paramMock, times(1)).get
    }
  }

}

class MockedClass {
  def get: String = {
    "foo"
  }
}

class TestClass {
  @Autowired
  var param: MockedClass = null

  def test: String = {
    param.get
  }
}