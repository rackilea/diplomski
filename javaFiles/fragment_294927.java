private static final NumberFormat THOUSANDS = new NumberFormat() {

    @Override
    public StringBuffer format(double number, StringBuffer toAppendTo, FieldPosition pos) {

        new DecimalFormat().format(number / 1000D, toAppendTo, pos);

        return toAppendTo;
    }

    @Override
    public StringBuffer format(long number, StringBuffer toAppendTo, FieldPosition pos) {
        return format((double) number, toAppendTo, pos);
    }

    @Override
    public Number parse(String source, ParsePosition parsePosition) {
        return null;
    }
};