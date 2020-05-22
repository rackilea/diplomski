String info = "You have 2$ on your public transport card and one active ticket which expires on 2017-08-09 23.59";
    Pattern pattern = Pattern.compile("(\\d\\$).*and\\s(.*)");
    Matcher m = pattern.matcher(info);
    while (m.find()) {
        System.out.println("First Group: " + m.group(1) + " \nSecond Group: " + m.group(2));
    }