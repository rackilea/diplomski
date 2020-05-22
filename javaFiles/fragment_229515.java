public static void main(String args[]) throws InterruptedException {
    try {
        System.out.println("why not?");
    } catch (IllegalArgumentException e) {
        System.out.println("here");
    } catch (IllegalStateException | ArithmeticException e) {
        System.out.println("there");
    }
}