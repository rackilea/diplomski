String s = "C:\\Temp\\myfile_124.txt";
Pattern p = Pattern.compile("_(\\d+)\\.txt$");
Matcher matcher = p.matcher(s);
if (matcher.find())
    for (int i = 0; i <= matcher.groupCount(); i++)
        System.out.println(i + ": " + matcher.group(i));