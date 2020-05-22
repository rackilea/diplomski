public class SessionCounter implements HttpSessionListener {
    private int counter = 0;

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        counter++;
        System.out.println("Total sessions created " + counter);
    }

    // other methods
}