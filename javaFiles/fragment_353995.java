// generate some strings....
for (String string : full) {
    Pattern pattern = Pattern.compile("(\\w+).*>(.{23}) ([^\\[]+)\\[([^\\]]+)]: (.+)");
    Matcher matcher =  pattern.matcher(string);
    System.out.println("matches:" + matcher.find() + ", string:" + string);
}