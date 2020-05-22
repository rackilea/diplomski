@Test(priority=3,dataProvider = "testData")
  public void test1(String str1[] ) {
      System.out.println("first string"+" "+str1[0]);

  }

  @Test(priority=4,dataProvider = "testData")
  public  void test2(String str2[]) {
      System.out.println("second string"+" " + str2[1]);

  }