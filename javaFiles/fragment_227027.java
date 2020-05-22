public class PlatformSuite implements ISuiteListener { 

    /**
     * This method is invoked before the SuiteRunner starts.
     */
    public synchronized void onStart(ISuite suite) {
        /*Your before suite implementation here*/
    }

    /**
     * This method is invoked after the SuiteRunner has run all
     * the test suites.
     */

    public void onFinish(ISuite suite) {
         /*Your after suite implementation here*/
    }

}}