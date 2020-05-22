String str = "<b>Defendants Name:</b>Donahue, Leah A                                                    <BR>";
    Pattern pattern = Pattern.compile(".*<b>(.*)<BR>.*", Pattern.UNIX_LINES);
    Matcher m = pattern.matcher(str);
    if (m.matches() == true)
    {
        System.out.println(m.group(1));
    }