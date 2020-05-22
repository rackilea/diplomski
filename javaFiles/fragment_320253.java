@Test(dataProvider="login8users") 
 @Parameters({"browser"})
 public void login8(String dataProvider1, String dataProvider2) {         

            System.out.println("Email from data provider is..: "+dataProvider1);
            System.out.println("Pass from data provider is..: "+dataProvider2);     

        }