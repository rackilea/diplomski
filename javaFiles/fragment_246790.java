public class Example {
    public static void endless() {
        endless();
    }

    public static void main(String args[]) {
        try {
            endless();
        } catch(StackOverflowError t) {
            // more general: catch(Error t)
            // anything: catch(Throwable t)
            System.out.println("Caught "+t);
            t.printStackTrace();
        }
        System.out.println("After the error...");
    }
}