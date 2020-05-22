private boolean waitForThread = true;

@Test
public void testSetUpBoard() {


    final boolean isFalse = false;

    Gdx.app.postRunnable(new Runnable() {
        @Override
        public void run() {
            //do stuff to game            
            waitForThread = false;
        }
    });

    while(waitForThread) {
        try {
            Thread.sleep(10);
        } catch(Exception e ) {
        }
    }

    // fail or pass...
    fail(); //see if the test will fail or not
}