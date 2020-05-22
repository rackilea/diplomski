interface RunnableE {
    void run() throws Exception;
}

class Example {

    public static void main(String[] args) {
        List<RunnableE> methods = Arrays.asList(
                () -> methodA1(),
                () -> methodA2(),
                () -> methodA3()
        );

        for (RunnableE method : methods) {
            try {
                method.run();
            } catch (Exception e) {
                // log the exception
            }
        }
    }

    private static void methodA1() throws Exception {
        System.out.println("A1");
    }

    private static void methodA2() throws Exception {
        System.out.println("A2");
    }

    private static void methodA3() throws Exception {
        System.out.println("A3");
    }

}