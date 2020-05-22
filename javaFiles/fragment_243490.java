public class Ypologismos {

    /** Entry point to the application. */
    public static void main(String[] args) {
        Ypologismos application = new Ypologismos();
        application.teachMultiplication();
    }

    private void teachMultiplication() {
        while (wantsAProblem()) {
             askAProblem();
        }
    }

    private void askAProblem() {
        int αλφα = random.nextInt(10);
        int βητα = random.nextInt(10);
        ...
    }
}