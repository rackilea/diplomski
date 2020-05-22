@RunWith(MyRunner.class)
public class MyRunnerTest {
    @Test
    public void testRunChild() {
        Assert.assertTrue(Runner.value);
    }
}