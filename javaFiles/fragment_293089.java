public class Driver {
   static String expectedTitle = "Home Page - Safe2Pay Application";
   static String actualTitle = "";
   public static void main(String args[]){

      Driver driver = new Driver();

      //Approach 1
      actualTitle = getTitle();

      if (actualTitle.contentEquals(expectedTitle)) {
        System.out.println("Test Passed");
      } else {
        System.out.println("Test Failed");
      }

      //Approach 2
      //Java 8 execution
      GetTitle m = (Driver dr) -> {
        if (Driver.getTitle().contentEquals(expectedTitle))
            System.out.println("Test Passed");
        else
            System.out.println("Test Failed");
      };

       m.operation(driver);

    }
    public static String getTitle(){
       return expectedTitle;
    }

   interface GetTitle {
      void operation(Driver driver);
   }
}