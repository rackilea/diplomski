private static String extract(String url) { // http://www.zillow.com/homes/for_sale/Laie-HI/110560800_zpid/18901_rid/pricea_sort/21.70624,-157.843323,21.565342,-158.027859_rect/12_zm/
    Pattern pattern = Pattern.compile("(\\d+)_zpid");
    Matcher matcher = pattern.matcher(url);
    while (matcher.find()) {
        return matcher.group(1); //110560800
    }
    return null;
}