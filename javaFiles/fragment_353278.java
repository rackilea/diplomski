final String regex = "\\d+";
    String string = "my name is anusha, I am a noob in Java having reputation: 3647 haha I am just kidding my actual reputation is 0001";
    NumberFormat formatter = new DecimalFormat("00.00");     

    final Pattern pattern = Pattern.compile(regex);
    final Matcher matcher = pattern.matcher(string);

    while (matcher.find()) {
        Float val=new Float(matcher.group(0));
        val=val/100;
        string=string.replace(matcher.group(0),formatter.format(val));
    }
    System.out.println(string);

}