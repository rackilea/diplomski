String regex = "^(\\d+)(yes|no)";
    String myStr = "10yes11no";

    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(myStr);

    while (m.find())
    {
        String all = m.group();
        String digits = m.group(1);
        String bool = m.group(2);

        // do not try and combine the next 2 lines ... it doesn't work!
        myStr = myStr.substring(all.length());
        m.reset(myStr);

        System.out.println(String.format("all = %s, digits = %s, bool = %s", all, digits, bool));
    }