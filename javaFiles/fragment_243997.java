public BigDecimal getBar() {
    if(null == bar) {
        return null;
    }
    return bar.getValue();
}

public void setBar(BigDecimal bar) {
    if(null == this.bar) {
        this.bar = new JAXBElement<BigDecimal>(new QName("bar"), BigDecimal.class, bar);
    } else {
        this.bar.setValue(bar);
    }
}