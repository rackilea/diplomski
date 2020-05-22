class Security {
    private String securityName;
    private Integer marketCap;
    private Profit profit = new Profit();

    public String getSecurityName() {
        return securityName;
    }

    @JsonProperty("security_name")
    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }

    public Integer getMarketCap() {
        return marketCap;
    }

    @JsonProperty("market_cap")
    public void setMarketCap(Integer marketCap) {
        this.marketCap = marketCap;
    }

    @JsonProperty("profit")
    public Profit getProfit() {
        return profit;
    }

    @JsonProperty("1_month_profit")
    public void setOneMonthProfit(Double oneMonthProfit) {
        this.profit.oneMonthProfit = oneMonthProfit;
    }

    @JsonProperty("3_month_profit")
    public void setThreeMonthProfit(Double threeMonthProfit) {
        this.profit.threeMonthProfit = threeMonthProfit;
    }

    @JsonProperty("6_month_profit")
    public void setSixMonthProfit(Double sixMonthProfit) {
        this.profit.sixMonthProfit = sixMonthProfit;
    }

    class Profit {
        private Double oneMonthProfit;

        private Double threeMonthProfit;

        private Double sixMonthProfit;

        @Override
        public String toString() {
            return "Profit [oneMonthProfit=" + oneMonthProfit + ", threeMonthProfit=" + threeMonthProfit
                    + ", sixMonthProfit=" + sixMonthProfit + "]";
        }
    }

    @Override
    public String toString() {
        return "Security [securityName=" + securityName + ", marketCap=" + marketCap + ", profit=" + profit + "]";
    }
}