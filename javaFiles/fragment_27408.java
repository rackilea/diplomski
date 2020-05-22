List<String> matchList = new ArrayList<String>();
    Pattern regex = Pattern.compile("\\'(.*?)\\'");
    String input = "'s'Hello This is 'Java' Not '.NET'";
    Matcher regexMatcher = regex.matcher(input);

    StringBuffer sb = new StringBuffer();
    int counter = 0;
    while (regexMatcher.find())
    {// Finds Matching Pattern in String
        regexMatcher.appendReplacement(sb, "{"+counter+"}");
        matchList.add(regexMatcher.group());// Fetching Group from String
        counter++;
    }
    String format = MessageFormat.format(sb.toString().toUpperCase(), matchList.toArray());
    System.out.println(input);
    System.out.println("----------------------");
    System.out.println(format);