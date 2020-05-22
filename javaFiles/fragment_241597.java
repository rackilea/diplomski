String s = "??.....!fsdgsdfgsdfgsdfg?.,!0000a";
Pattern p = Pattern.compile("([.,!?]+)");
Matcher m = p.matcher(s);
while(m.find()) {
    System.out.println(m.group(1));
}