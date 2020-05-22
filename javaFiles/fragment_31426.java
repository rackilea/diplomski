class sample {

    boolean isFailed = false;

    void m1() throws Exception {
        // logic of method
    }

    void m1Caller() {

        try {

            m1();

        } catch (Exception e) {

            // do whatever you want with the Exception's message
            System.out.println(e.getMessage());
            isFailed = true;

        }

    }

}