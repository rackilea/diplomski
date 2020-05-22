//if you are using JUnit4 add in the @Test annotation, JUnit3 works without it.
//@Test
public void testGetFilter(){
    try{
        Expression myReturnedObject = getFilter("testString");
        assertNotNull(myReturnedObject);//check if the object is != null
        //checks if the returned object is of class Expression
        assertTrue( true, myReturnedObject instaceof Expression);
    }catch(Exception e){
        // let the test fail, if your function throws an Exception.
        fail("got Exception, i want an Expression");
     }
}