public class TestParse {

    public void doTest()
    {
        Stockmarket stockmarket1 = new Stockmarket("17-Mar-2006",500,600);
        stockmarket1.date();
        System.out.println(stockmarket1.date());

        Stockmarket stockmarket2 = new Stockmarket("16-Jan-2002",500,600);
        stockmarket2.date();
        System.out.println(stockmarket2.date());

        Stockmarket stockmarket3 = new Stockmarket("15-Jun-2003",500,600);
        stockmarket3.date();
        System.out.println(stockmarket3.date());

    }
    public static void main(String[] args) {

        TestParse testParse = new TestParse();
        testParse.doTest();
    }
}