public <T> T takeInput(Callable<T> input, String label) {

    while (true) {
        try {
            System.out.print(label + ": ");
            return input.call();
        } catch (InputMismatchException e) {
            System.out.println("bad input, try again");
            input.next();             
        }
        catch (Exception e) {
            System.out.println("other exception...");
        }
    }
}