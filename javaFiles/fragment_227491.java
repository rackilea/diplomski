import org.springframework.mock.web.MockHttpServletRequest
import org.springframework.mock.web.MockHttpServletResponse
import org.testng.Assert
import org.testng.annotations.Test

class SomeServletTest {

    @Test
    void aTest() {
        def request = new MockHttpServletRequest(
                characterEncoding: "UTF-8",
                content: "some text".bytes)

        def response = new MockHttpServletResponse()

        def ss = new SomeServlet()
        ss.doPost(request, response)

        Assert.assertEquals(response.getContentAsString(), "some text")
    }
}