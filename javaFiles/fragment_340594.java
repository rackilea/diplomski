public class Snippet {

    @Test
    public void test1() throws Exception {
        final MyHandler handler = new MyHandler();
        final Method privateStringMethod = MyHandler.class.getDeclaredMethod("isvalid");
        privateStringMethod.setAccessible(true);
        final Boolean s = (Boolean) privateStringMethod.invoke(handler);
        Assert.assertTrue(s.booleanValue());
    }

    class MyHandler {
        private boolean isvalid() {
            return false;
        }
    }
}