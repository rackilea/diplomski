public class CustomBigDecimalConverter extends BigDecimalConverter {

    @Override
    public BigDecimal convertToObject(String value, Locale locale) {
        // NB: this isn't universal & your mileage problably varies!
        // (Specifically, this breaks if '.' is used as thousands separator)
        if ("fi".equals(locale.getLanguage())) {
            value = value.replace('.', ',');
        }
        return super.convertToObject(value, locale);
    }
}