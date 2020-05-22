Pattern p = Pattern.compile("(?:^|[: ])("+searchString+")(?!\\|null)", Pattern.CASE_INSENSITIVE);
 Matcher m = p.matcher("One Two Three|null:Two Two Three|10:Two Three|10:Six Two Three|null");

while(m.find()) {
    System.out.println(m.group(1));
}