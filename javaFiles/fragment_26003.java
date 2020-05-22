final String regex = "(?<key>[\\w\\s]+:)\\s*(?<value>.+?)\\s*(?=(?:[Aa]rtist|[Tt]itle|(?:[Ff]ramed )?[Dd]imensions):|$)";
final String string = "Artist: foo Title: bar Dimensions: x Framed dimensions: y";

final Pattern pattern = Pattern.compile(regex);
final Matcher m = pattern.matcher(string);

Map<String, String> itemMap = new LinkedHashMap<>();
while (m.find()) {
    itemMap.put(m.group("key"), m.group("value"));
}

System.out.println("itemMap: " + itemMap);