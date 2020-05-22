String str = "ID: GF68464, Name: productname";

Matcher m = Pattern.compile("ID:\\s*(\\w+),").matcher(str);
if (m.find()) {
    System.out.println(m.group(1));
}