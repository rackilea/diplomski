/**
 * This is a small example to get you started.
 * This is an example of a test class to test your loadStore
 * It assumes this method is defined in a class called StoreManager.
 * It encapsulates all the tests that are required within the same test method for
 * expediency sake. You generally should restrict one core functionality per test.
 * but if writing functional test, you can groupd core functionality together.
 * 
 * Provide you default input data. Provide data that should pass as well
 * as data that should fail or error according to all the possible conditions you can think off.
 * 
 * it is fine to hardcode the data when when starting out but later you need to look
 * into defining test data in some sort of reusable way as well as easy to maintain as data changes.
 * 
 * it is good practice not to run test against DB databases.
 * 
 * 
 */

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
public class StoreManagerTest {

@BeforeClass
    public void before()
    {
    //in here do some pre-initilization for each test class if needed
    //database login if needed 
    //mock objects if needed etc
    }

@Before
public void beforeTest()
{
    //in here do some pre-initilization for each test if needed

}

@After
public void afterTest()
{
    //in here do some cleanup for each test if needed
}




@Test
public void testloadStore() {

        StoreManager storeManager = new StoreManager();
        Integer validCustomerId = new Integer(9876);
        Integer invalidCustomerId = new Integer(-10);

        Integer validStoreId = new Integer(2345);
        Integer invalidStoreId = new Integer(-345);

        String validCustomerName = new String("validname);

        String validStoreName = new String("validStoreName);

        //Test first with valid id.
        //expect to return a store. if store is undefined the assertTrue will fail.
        //if you get an error fail. need to invetigate why you are failing with valid store id and valid customer id.
        try{
            Store store = storeManager.loadStore(validCustomerId, validStoreId);
            assertNotNull(store);
            assertTrue(store.getStoreId().equals(validStoreId));
            assertTrue("customer id match : " , store.getCustomerId().equals(validCustomerId));
            //you can also check for other parameters that exist in store object
            assertSame("customer Name match :  ", store.getCustomerName(), validCustomerName);
            assertSame("Store Name match :  ", store.getStoreName(), validStoreName);
        }catch(Exception e){
            fail("testHashCode Failed! " + e.getMessage());
        }


        //Test  with valid id and invalid customerid
        //expect error or null store. if store is undefined the assertTrue will pass.
        //if you get an error fail perfectly valid to assume the test passed but you can write other test to test
        //whether the error condition is what was expected.
        try{
            Store store = storeManager.loadStore(invalidCustomerId, validStoreId);
            assertNull(store);
        }catch(Exception e){
            assertTrue("No Store matching :  "+invalidCustomerId, true);
        }

        //Test  with invalid  storeid and valid customerid
        //expect error or null store. if store is undefined the assertTrue will pass.
        //if you get an error fail perfectly valid to assume the test passed but you can write other test to test
        //whether the error condition is what was expected.
        try{
            Store store = storeManager.loadStore(validCustomerId, invalidStoreId);
            assertNull(store);
        }catch(Exception e){
            assertTrue(true);
        }


        //Test  with invalid  storeid and invalid customerid
        //expect error or null store. if store is undefined the assertTrue will pass.
        //if you get an error fail perfectly valid to assume the test passed but you can write other test to test
        //whether the error condition is what was expected.
        try{
            Store store = storeManager.loadStore(null, null);
            assertNull(store);
        }catch(Exception e){
            assertTrue(true);
        }


}

}