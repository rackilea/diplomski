public class ItemMaster {
    @Converter(
        name="periodConverter",
        converterClass = com.joda.converter.PeriodConverter.class
    )
    @Convert("periodConverter")
    @Column(name = "expiry_limit", length = 2000)
    private Period expiryLimit;

    /** Constructors **/


    public Period getExpiryLimit() {
        return expiryLimit;
    }

    public void setExpiryLimit(Period expiryLimit) {
        this.expiryLimit = expiryLimit;
    }
}