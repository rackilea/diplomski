public class Test {

    public static void main(final String[] args) {
        new Test().doStuff();
    }

    private void doStuff() {
        long start;
        long end;
        while (true) {
            start = System.nanoTime();
            Point point = MouseInfo.getPointerInfo().getLocation();
            end = System.nanoTime();
            System.out.println("Time taken: " + (end - start));
        }
    }

}