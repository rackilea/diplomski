String patternString = "Shopify.theme\\s*=\\s*.*theme_store_id\\"\\:(\\d+)";
Pattern pattern = Pattern.compile(patternString);
Matcher matcher = pattern.matcher(text);

String themeStoreId;
while (matcher.find()) {
    themeStoreId = matcher.group(1);
}