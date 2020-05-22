String s = "A Basket of !fruit! was lost";
    String toCompare = "A Basket of Apples was lost";
    Pattern pattern = Pattern.compile(s.replace("!fruit!", "(.*)"));
    Matcher matcher = pattern.matcher(toCompare);
    if (matcher.find()) {
        System.out.println(matcher.group(1));
    }