String s = "<$FB $TWTR are getting plummetted>";
Pattern pattern = Pattern.compile("<([^>]+)>");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    String[] chks = matcher.group(1).split(" ");
    for (int i = 0; i<chks.length; i++)
    {
        if (chks[i].startsWith("$"))
            System.out.println(chks[i].substring(1));
    }
}