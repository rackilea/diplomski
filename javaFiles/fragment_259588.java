public static String priceWithDecimal (Double price) {
    DecimalFormat formatter = new DecimalFormat("###,###,###.00");
    return formatter.format(price);
}

public static String priceWithoutDecimal (Double price) {
    DecimalFormat formatter = new DecimalFormat("###,###,###.##");
    return formatter.format(price);
}