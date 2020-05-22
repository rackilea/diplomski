package stock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Portfolio is a collection of Stocks
 * @author Michael
 * @link https://stackoverflow.com/questions/24417246/yield-calculation/24430415
 * @since 6/26/2014 6:31 PM
 */
public class Portfolio {

    private Map<Stock, Integer> stocks;

    public Portfolio() {
        this.stocks = new ConcurrentHashMap<Stock, Integer>();
    }

    public void addStock(Stock stock, int numShares) {
        if (stock == null) throw new IllegalArgumentException("stock cannot be null");
        this.stocks.put(stock, numShares);
    }

    public void addStock(Stock stock) {
        addStock(stock, 1);
    }

    public void updateShares(Stock stock, int numShares) {
        if (numShares <= 0) throw new IllegalArgumentException("numShares must be greater than zero");
        if (stock != null) {
            this.stocks.put(stock, numShares);
        }
    }

    public void removeStock(Stock stock) {
        if (stock != null) {
            this.stocks.remove(stock);
        }
    }

    public boolean containsSymbol(String symbol) {
        return this.getPortfolioSymbols().contains(symbol);
    }

    public int getNumShares(String symbol) {
        int numShares = 0;
        if (this.getPortfolioSymbols().contains(symbol)) {
            numShares = this.stocks.get(new Stock(symbol, "Dummy Company Name"));
        }
        return numShares;
    }

    public int getNumStocks() {
        return this.stocks.size();
    }

    public List<String> getPortfolioSymbols() {
        List<String> symbols = new ArrayList<String>(this.stocks.size());
        for (Stock stock : stocks.keySet()) {
            symbols.add(stock.getSymbol());
        }
        Collections.sort(symbols);
        return symbols;
    }

    public double calculateValue(Date date) {
        double value = 0.0;
        if (date != null) {
            for (Stock stock : this.stocks.keySet()) {
                value += stock.getPrice(date)*this.stocks.get(stock);
            }
        }
        return value;
    }
}