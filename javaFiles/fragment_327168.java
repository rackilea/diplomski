package stock;

import utils.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Stock abstraction
 * @author Michael
 * @link https://stackoverflow.com/questions/24417246/yield-calculation/24430415
 * @since 6/26/2014 6:22 PM
 */
public class Stock implements Comparable<Stock> {
    private final String symbol;
    private final String companyName;
    private Map<Date, Double> prices;

    public Stock(String symbol, String companyName) {
        if (StringUtils.isBlankOrNull(symbol)) throw new IllegalArgumentException("symbol cannot be blank or null");
        if (StringUtils.isBlankOrNull(companyName)) throw new IllegalArgumentException("company name cannot be blank or null");
        this.symbol = symbol;
        this.companyName = companyName;
        this.prices = new ConcurrentHashMap<Date, Double>();
    }

    public String getSymbol() {
        return symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void addPrice(Date date, double price) {
        if (date == null) throw new IllegalArgumentException("date cannot be null");
        if (price < 0.0) throw new IllegalArgumentException("price cannot be negative");
        this.prices.put(date, price);
    }

    public void removePrice(Date date) {
        if (date != null) {
            this.prices.remove(date);
        }
    }

    public synchronized Double getPrice(Date date) {
        double price = 0.0;
        if (this.prices.containsKey(date)) {
            price = this.prices.get(date);
        } else {
            price = interpolatePrice(date);
        }
        return price;
    }

    private Double interpolatePrice(Date date) {
        double price = 0.0;
        if (this.prices.size() > 0) {
            List<Date> dates = new ArrayList<Date>(this.prices.keySet());
            Collections.sort(dates, new DateComparator());
            if (date.before(dates.get(0))) {
                price = this.prices.get(dates.get(0));
            } else if (date.after(dates.get(dates.size()-1))) {
                price = this.prices.get(dates.get(dates.size()-1));
            } else {
                for (int i = 1; i < dates.size(); ++i) {
                    if (dates.get(i).after(date)) {
                        Date d1 = dates.get(i-1);
                        double p1 = this.prices.get(d1);
                        Date d2 = dates.get(i);
                        double p2 = this.prices.get(d2);
                        double fraction = ((double)(date.getTime()-d1.getTime())/(d2.getTime()-d1.getTime()));
                        price = p1 + fraction*(p2-p1);
                    }
                }
            }
        }
        return price;
    }

    public boolean hasDate(Date date) {
        return this.prices.containsKey(date);
    }

    public int getNumPrices() {
        return this.prices.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;

        return symbol.equals(stock.symbol);
    }

    @Override
    public int hashCode() {
        return symbol.hashCode();
    }

    @Override
    public int compareTo(Stock other) {
        return this.symbol.compareTo(other.symbol);
    }

    @Override
    public String toString() {
        return this.symbol;
    }
}

class DateComparator implements Comparator<Date> {
    @Override
    public int compare(Date that, Date another) {
        if (that.before(another)) {
            return -1;
        } else if (that.after(another)) {
            return +1;
        } else {
            return 0;
        }
    }
}