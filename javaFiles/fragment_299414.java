/**
 * Some GUI class, should only be accessed from the EDT
 */
public class B extends JPanel {

    private int value = 0;

    private E thatThreadObject;

    public void setE( E e ) {
        thatThreadObject = e;
    }    
    public void setValue( int newValue ) {
        value = newValue;
        System.out.println( "Got a new int value: " + value );
    }

    public void triggerKeyEvent() {
        thatThreadObject.keyEvent();
    }
}

/**
 * Must be thread-safe, as accessed from multiple threads
 */
public class E implements Runnable{
    private B thatGuiObject;
    // Note, latch is only good for one-time use.
    private final CountDownLatch latch = new CountDownLatch( 1 );

    public void setB( B b ) {
        thatGuiObject = b;
    }

    public void keyEvent() {
        // Wake up the waiting thread
        latch.countDown();            
    }

    @Override
    public void run() {
        try {
            // Wait for key event forever, better than busy looping
            latch.await();
            // Update B, but it's a Swing component so use EDT
            EventQueue.invokeLater( new Runnable() {
                @Override
                public void run() {
                    thatGuiObject.setValue( 4 );
                }
            } );
        }
        catch ( InterruptedException e ) {
            e.printStackTrace();
        }            
    }
}