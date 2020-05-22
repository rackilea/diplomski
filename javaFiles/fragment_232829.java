@BeforeClass
  @Parameters({"testParam"})
  public void init(String suiteParam) {
    this.suiteParam = suiteParam;
  }




 @DataProvider(name = "testDataProvider")
  public Object[][] createData1() {
      String testParam = suiteParam;
      int theNums[][] = new int[][] {{10,20},{100,110}};
      return new Object[][] {
       { testParam, theNums }

  };

  }



  @Test(dataProvider = "testDataProvider") 

  public  void testingParam( String DPparam1, int[][] DPparam2) {

      System.out.println("xml param from @beforeclass param through data provider:  " + DPparam1);
      System.out.println("xml param from @beforeclass without DP: " + suiteParam);
      System.out.println("configured param from data provider: " + DPparam2[0][0]);
      }



      @Test
public  void testingParam2( ) {

      System.out.println("xml param from @beforeclass in different method: " + suiteParam);
      }