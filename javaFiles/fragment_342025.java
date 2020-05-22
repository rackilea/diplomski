public static void main(String[] args) throws Exception {
    List<String> keywords = new ArrayList(Arrays.asList("FIRSTNAME", "LASTNAME", "CURRENCY", "FUND"));
    List<String> dataList = new ArrayList(Arrays.asList("HUSBANDFIRSTNAME", "HUSBANDLASTNAME", "WIFEFIRSTNAME", "SOURCECURRENCY", "CURRENCYRATE"));
    Set<String> targetSet = new HashSet();

    String pattern = String.join("|", keywords);
    for (String data : dataList) {
        Matcher matcher = Pattern.compile(pattern).matcher(data);
        if (matcher.find()) {
            targetSet.add(matcher.group());
        }
    }

    System.out.println(targetSet);
}