String str = "pies osa. Pszczol 10, miod mis kon, pies osa. Kon 15";
Pattern ptrn = Pattern.compile("\\bpies\\s+osa\\W*(\\w+\\s*\\d+)");
Matcher matcher = ptrn.matcher(str);
while (matcher.find()) {
    System.out.println(matcher.group(1));
}
// => Pszczol 10, Kon 15