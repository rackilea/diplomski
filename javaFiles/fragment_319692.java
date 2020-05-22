import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized::class)
class HelloTest(val param1: Int, val param2: Int) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
                arrayOf(1, 2),
                arrayOf(1, 3)
        )
    }
    @Test
    fun `first test`() {
        val sMock = setUpMock(param1, param2)
        println(sMock.mock.get(1))
    }

    @Test
    fun `second test`() {
        val sMock = setUpMock(param1, param2)
        println(sMock.mock.get(1))
        verify(sMock.mock).get(1)
    }
}