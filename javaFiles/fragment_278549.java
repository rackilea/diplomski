@Override
protected IConverterLocator newConverterLocator() {
    ConverterLocator converterLocator = new ConverterLocator();
    converterLocator.set(BigDecimal.class, new CustomBigDecimalConverter());
    return converterLocator;
}