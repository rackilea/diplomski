public class MyTest {

    private String a;
    private String b;
    private boolean c;

    private ClassUnderTest instance = new ClassUnderTest() {
        @Override
        public void doAction(String a, int b, boolean c) {
            MyTest.this.a = a; 
            MyTest.this.b = b;
            MyTest.this.c = c;
        }
    }

    public void test() {
        // SETUP
        String expectedA = "test value A";
        String expectedB = "test value B";
        boolean expectedC = true;

        // CALL
        instance.doActionOne(expectedA, expectedB);

        // VERIFY
        assertEquals(expectedA, a);
        assertEquals(expectedB, b);
        assertEquals(expectedC , c);
    }