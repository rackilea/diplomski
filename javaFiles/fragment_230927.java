String str1 = "-0.6";
String str2 = "-.6";
if (NumberUtils.isNumber(str1) && NumberUtils.isNumber(str2)) {
    Double d1 = NumberUtils.createDouble(str1);
    Double d2 = NumberUtils.createDouble(str2);
    System.out.println(d1.equals(d2));
} else {
    System.out.println(str1.equals(str2));
}