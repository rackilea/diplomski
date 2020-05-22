class CurrencyAndAmount {

    @JacksonXmlText
    protected BigDecimal value;

    @JacksonXmlProperty(localName = "Currency", isAttribute = true)
    protected String currency;

    ...
}