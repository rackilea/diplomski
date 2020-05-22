class Hi {
    public static void main(String args[]) {
        String hello = "Hello";
        try {
            Thread.sleep(60_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}