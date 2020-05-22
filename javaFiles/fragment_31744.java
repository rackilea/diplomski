@Test
public void test() throws Exception
{
    try
    {
         //some code over here

         // last line of try block
         System.out.print("Test Case: Successful"); 
    }
    catch(Exception e)
    {
        System.out.println("Test Case: Failed");
        System.out.println("Failing Reason: "+ e.toString());
    }
}