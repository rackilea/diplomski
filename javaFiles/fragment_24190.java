@Test
    public void testDoSmth() {
        ClassForTest testMock = spy(new ClassForTest());
        testMock.doSmth();
        verify(testMock, times(3)).prepareValue(anyString());
    }

    public class ClassForTest {
        private Integer value = 0;

        public void doSmth() {
            prepareValue("First call");
            prepareValue("Second call");
            prepareValue("Third call");
            System.out.println(value);
        }

        protected void prepareValue(String msg) {
            System.out.println("This is message: " + msg);
            value++;
        }
    }