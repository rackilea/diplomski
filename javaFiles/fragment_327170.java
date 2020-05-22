package stock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PortfolioTest JUnit test for Portfolio
 * @author Michael
 * @link https://stackoverflow.com/questions/24417246/yield-calculation/24430415
 * @since 6/26/2014 8:33 PM
 */
public class PortfolioTest {

    private static final String DATE_PATTERN = "yyyy-MMM-dd";
    private static final DateFormat DATE_FORMAT;
    private static final double TOLERANCE = 0.001;

    static {
        DATE_FORMAT = new SimpleDateFormat(DATE_PATTERN);
        DATE_FORMAT.setLenient(false);
    }

    private Portfolio portfolio;

    @Before
    public void setUp() throws ParseException {
        this.portfolio = new Portfolio();
        Stock testStock = new Stock("AAPL", "Apple Inc");
        testStock.addPrice(DATE_FORMAT.parse("2014-Jun-02"), 89.807);
        testStock.addPrice(DATE_FORMAT.parse("2014-Jun-04"), 92.117);
        this.portfolio.addStock(testStock, 100);
        testStock = new Stock("ORCL", "Oracle Corporation");
        testStock.addPrice(DATE_FORMAT.parse("2014-Jun-02"), 41.97);
        testStock.addPrice(DATE_FORMAT.parse("2014-Jun-04"), 41.70);
        this.portfolio.addStock(testStock, 1000);
    }

    @Test
    public void testPortfolio_Setup() {
        List<String> expectedSymbols = Arrays.asList("AAPL", "ORCL");
        Assert.assertEquals(expectedSymbols, this.portfolio.getPortfolioSymbols());
        for (String symbol : expectedSymbols) {
            Assert.assertTrue(this.portfolio.containsSymbol(symbol));
        }
        Assert.assertEquals(expectedSymbols.size(), portfolio.getNumStocks());
        Assert.assertFalse(this.portfolio.containsSymbol("UTX"));
    }

    @Test
    public void testRemoveStock_ContainsStock() {
        int expectedSize = 2;
        Assert.assertEquals(expectedSize, portfolio.getNumStocks());
        Stock testStock = new Stock("AAPL", "Apple Inc");
        this.portfolio.removeStock(testStock);
        Assert.assertEquals(expectedSize - 1, portfolio.getNumStocks());
    }

    @Test
    public void testRemoveStock_DoesNotContainStock() {
        int expectedSize = 2;
        Assert.assertEquals(expectedSize, portfolio.getNumStocks());
        Stock testStock = new Stock("UTXL", "United Technologies Corporation");
        this.portfolio.removeStock(testStock);
        Assert.assertEquals(expectedSize, portfolio.getNumStocks());
    }

    @Test
    public void testGetNumShares_ContainsSymbol() {
        Map<String, Integer> expected = new HashMap<String, Integer>() {{
            put("AAPL", 100);
            put("ORCL", 1000);
        }};
        for (String symbol : expected.keySet()) {
            Assert.assertTrue(expected.get(symbol) == portfolio.getNumShares(symbol));
        }
    }

    @Test
    public void testGetNumShares_DoesNotContainSymbol() {
        Assert.assertEquals(0, portfolio.getNumShares("UTX"));
    }

    @Test
    public void testCalculateValue_BeforeFirstDate() throws ParseException {
        Date testDate = DATE_FORMAT.parse("2014-Jun-02");
        double expected = 89.807*100 + 41.97*1000;
        double actual = portfolio.calculateValue(testDate);
        Assert.assertEquals(expected, actual, TOLERANCE);
    }

    @Test
    public void testCalculateValue_AfterLastDate() throws ParseException {
        Date testDate = DATE_FORMAT.parse("2014-Jul-04");
        double expected = 92.117*100 + 41.70*1000;
        double actual = portfolio.calculateValue(testDate);
        Assert.assertEquals(expected, actual, TOLERANCE);
    }


    @Test
    public void testCalculateValue_Interpolate() throws ParseException {
        Date testDate = DATE_FORMAT.parse("2014-Jun-03");
        double expected = 90.962*100 + 41.835*1000;
        double actual = portfolio.calculateValue(testDate);
        Assert.assertEquals(expected, actual, TOLERANCE);
    }

    @Test
    public void testUpdateShares() {
        Stock testStock = new Stock("ORCL", "Oracle Corporation");
        Assert.assertEquals(1000, this.portfolio.getNumShares("ORCL"));

        this.portfolio.updateShares(testStock, 10);
        Assert.assertEquals(10, this.portfolio.getNumShares("ORCL"));
    }
}