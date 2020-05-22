@RunWith(DataProviderRunner.class)
public class TestMyClass {

    @DataProvider
    public static Object[][] firstDataset() {
    return new Object[][] {     
             { 3,4 }, { 4,5 }, { 5,6 },{ 6,7 }  
       };
    }


    @DataProvider
    public static Object[][] secondDataset() {
    return new Object[][] {     
             { 3,4 }, { 4,5 }, { 5,6 },{ 6,7 }  
       };
    }

    @Test
    @UseDataProvider("firstDataset")
    public void test1(int a, int b) { //test }

    @Test
    @UseDataProvider("secondDataset")
    public void test2(int a, int b) { //test }

}