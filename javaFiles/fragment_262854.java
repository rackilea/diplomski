String data = "Nike, Adidas, Reebok";
String[] shoes = data.split(",\\s?");
for (int i=0; i < shoes.length; ++i) {
    shoes[i] = "\"" + shoes[i] + "\"";
}
Set<String> shoesSet = new HashSet<String>(Arrays.asList(shoes));