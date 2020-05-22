public class stacktest  {


@Test
public void teststackquestion() {

    boolean actual = true;
    boolean expected = false;
   Assert.assertEquals(actual, expected);

}


@AfterMethod
public void afterMethod(ITestResult result)
{
    try
 {
    if(result.getStatus() == ITestResult.SUCCESS)
    {

        //Do something here
        System.out.println("passed **********");
    }

    else if(result.getStatus() == ITestResult.FAILURE)
    {
         //Do something here
        System.out.println("Failed ***********");

    }

     else if(result.getStatus() == ITestResult.SKIP ){

        System.out.println("Skiped***********");

    }
}
   catch(Exception e)
   {
     e.printStackTrace();
   }

}