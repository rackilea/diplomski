String data = "background: url('../../footer/right.png') repeat;\r\n" + 
        "\r\n" + 
        "background: url(\"../../footer/left.png\") repeat;";
Pattern p = Pattern.compile("\\(('|\")(.*?)\\1\\)");
Matcher m = p.matcher(data);
while (m.find())
    System.out.println(m.group(2));