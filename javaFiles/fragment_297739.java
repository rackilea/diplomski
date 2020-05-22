class Prices {
    BigDecimal price1;
    BigDecimal price2;
    public Prices(BigDecimal price1, BigDecimal price2) {
        this.price1 = price1;
        this.price2 = price2;
    }
    public BigDecimal getPrice1() {
        return price1;
    }
    public void setPrice1(BigDecimal price1) {
        this.price1 = price1;
    }   
    public BigDecimal getPrice2() {
        return price2;
    }
    public void setPrice2(BigDecimal price2) {
        this.price2 = price2;
    }
    @Override
    public String toString(){
        return String.valueOf(price1).concat(" ").concat(String.valueOf(price2));
    }
}