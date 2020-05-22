public void setUp() throws Exception {
    super.setUp();
    /*
     * Add any necessary initialization code here (e.g., open a socket).
     * Call Repository.putTemporary() to provide initialized instances of
     * objects to be used when testing.
     */
    // jtest.Repository.putTemporary("name", object);
}

/**
 * Used to clean up after the test. This method is called by JUnit after
 * each of the tests have been completed.
 * 
 * @see junit.framework.TestCase#tearDown()
 * @author Parasoft Jtest 9.5
 */
public void tearDown() throws Exception {
    try {
        /*
         * Add any necessary cleanup code here (e.g., close a socket).
         */
    } finally {
        super.tearDown();
    }
}