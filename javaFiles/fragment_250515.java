DecimalFormat df = new DecimalFormat("#.###");
try {
    return df.parse(df.format(d)).doubleValue();
} catch (ParseException e) {
    throw new AssertionError(e.toString(), e);
}