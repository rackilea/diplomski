java.lang.String skuID = "";
Pattern pattern = Pattern.compile("sku\\d+");
Matcher m = pattern.matcher(recommendedOfferHTML);
while(m.find()) {
    skuID = m.group(1);
}