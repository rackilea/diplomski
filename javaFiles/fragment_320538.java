String text = "The price is 1 000$ another pice 34 000 , 00 EUR. You have to pay 1400 EUR, and you have to pay extra 2000$";
String regex = "(\\bpay(?:\\s+extra)?\\s*)?(\\d[\\d\\s,.]*)(?:\\$|EUR)";
Pattern pattern = Pattern.compile(regex);
Matcher m = pattern.matcher(text);
List<String> res = new ArrayList<>();
while (m.find()) {
    if (m.group(1) == null) {
        res.add(m.group(2).replaceAll(",\\s*\\d+|\\D", ""));
    }
}
System.out.println(res);
// => [1000, 34000]