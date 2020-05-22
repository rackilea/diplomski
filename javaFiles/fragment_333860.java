String str = 
       "id1 IN (SELECT id2 FROM product_application WHERE product1 = {{this.product2}})";

String regex = "(id\\d+)|(product_\\w+)|(product\\d+)";
Pattern pat = Pattern.compile(regex);
Matcher mat = pat.matcher(str);
List<String> list = new ArrayList<>();
while (mat.find()) {
    list.add(mat.group());
}
System.out.println(list);