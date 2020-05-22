public class SO {

    private static void a() {
        a();
    }

    public static void main(String[] args) throws InterruptedException {
    final Thread t = new Thread( new Runnable() {
        public void run() {
            a();
        }
    });
    t.start();
    while ( true ) {
        Thread.sleep( 2000 );
        System.out.println( "I'm still running @ " + System.currentTimeMillis() );
    }
}