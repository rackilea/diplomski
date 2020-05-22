public static String getPrice(String pattern) {
    BigDecimal basePrice = new BigDecimal("23");
    BigDecimal vatRate = new BigDecimal("0.5");
    BigDecimal price = basePrice.multiply(BigDecimal.ONE.add(vatRate));
    BigDecimal priceInPence = price.multiply(new BigDecimal("100"));
    BigDecimal annualPrice = price.multiply(new BigDecimal("365"));

    Matcher matcher = Pattern.compile("%(\\d+)\\$.(\\d+)f").matcher(pattern);

    while (matcher.find()) {
        String index = matcher.group(1);

        int scale = Integer.parseInt(matcher.group(2));

        if (index.equals("1"))
            priceInPence = priceInPence.setScale(scale, RoundingMode.HALF_EVEN);
        else if (index.equals("2"))
            annualPrice = annualPrice.setScale(scale, RoundingMode.HALF_EVEN);
    }

    return String.format(pattern, priceInPence, annualPrice);
}