Pattern pattern = Pattern.compile("^(\\S+)\\s+(\\S+).*");
    Matcher matcher = pattern.matcher("hsad vova 13/12/1995 16/05/2005 01/09/2017 17/03/2018");
    if (matcher.matches()) {
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
    }