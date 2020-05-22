public class Quote implements Serializable  {

    private static final long serialVersionUID = 1L;

    private String symbol;
    private String name;
    private String change;
    private String percentChange;
    private String open;
    private String daysHigh;
    private String daysLow;
    private String dividendYield;
    private String volume;
    private String averageDailyVolume;
    private String peRatio;
    private String marketCapitalization;
    private String yearHigh;
    private String yearLow;
    private String lastTradePriceOnly;


    private static final ThreadLocal<DecimalFormat> df = new ThreadLocal<DecimalFormat> {
        @Override
        protected DecimalFormat initialValue() {
            return new DecimalFormat("#,###,###,###,###,##0.00");
        }
    }

    private static final ThreadLocal<DecimalFormat> vf = new ThreadLocal<DecimalFormat> {
        @Override
        protected DecimalFormat initialValue() {
            return new DDecimalFormat("#,###,###,###,###,##0");
        }
    }

    // snip...

}