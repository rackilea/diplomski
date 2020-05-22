@RunWith(PowerMockRunner.class)
@PrepareForTest(PowerTest.ClassToUT.class)
public class PowerTest {

    public static class ClassToUT {

        public static String getEvent(String id) {
            return getEvent(id, null);
        }

        private static String getEvent(String id, String name) {
            // do something
            logEvent(id, name);
            return "s";
        }

        private static void logEvent(String id, String name) {
            throw new RuntimeException();
        }
    }

    @Test
    public void testGetEvent() throws Exception {

        PowerMockito.spy(ClassToUT.class);
        PowerMockito.doNothing().when(ClassToUT.class, "logEvent", any(), any());

        Assert.assertEquals("s", ClassToUT.getEvent("xyz"));
    }
}