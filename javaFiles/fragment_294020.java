public final class CurrencyData {

    @SerializedName("rates")
    private Map<String, BigDecimal> rates = new HashMap<>();

    @SerializedName("base")
    private String base;

    @SerializedName("date")
    private String date;

    public Map<String, BigDecimal> getRates() {
        return rates;
    }

    public void setRates(Map<String, BigDecimal> rates) {
        this.rates = rates;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}