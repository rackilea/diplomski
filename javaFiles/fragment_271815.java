@Retention(RetentionPolicy.RUNTIME)
    @interface Cache {
        int minute();
    }

    public class OrderClient extends Client {
        @Cache(minute = 5)
        public void synchronizrWithCustomerId(String customerId) throws NoSuchMethodException {
            // So some stuff setup body and header
            super.synchronize();
        }
    }

    public void doTest() throws NoSuchMethodException {
        OrderClient oc = new OrderClient();
        oc.synchronizrWithCustomerId("blabla");
    }

    public static void main(String[] args) throws NoSuchMethodException {
        TestS1 t = new TestS1();
        t.doTest();
    }

}