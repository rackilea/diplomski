public class BlankAsNullNumberFormatter extends NumberFormatter {
    private static final long serialVersionUID = 5867546077017490042L;

    public BlankAsNullNumberFormatter(Class<? extends Number> numberKlazz) {
        setValueClass(numberKlazz);
    }

    public BlankAsNullNumberFormatter(Class<? extends Number> numberKlazz, NumberFormat format) {
        super(format);
        setValueClass(numberKlazz);
    }

    public String valueToString(Object iv) throws ParseException {
        if (iv == null) {
            return "";
        } else {
            return super.valueToString(iv);
        }
    }

    public Object stringToValue(String text) throws ParseException {
        if ("".equals(text)) {
            return null;
        }

        return super.stringToValue(text);
    }
}