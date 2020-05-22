String str = "STAR=20110209 00:01:01|PNAM=test_.xml|PNUM=480|SSTA=20110209 00:01:01|STRT=20110209 00:01:01|STOP=20110209 00:01:01|";
Pattern p = Pattern.compile("([^=]*)=([^|]*)\\|");
Matcher m = p.matcher(str);
String pnamVal = null, sstaVal = null;
while (m.find()) {
    //System.out.println("Matched: " + m.group(1) + '=' + m.group(2));
    if (m.group(1).equals("PNAM"))
        pnamVal = m.group(2);
    else if (m.group(1).equals("SSTA"))
        sstaVal = m.group(2);

    if (pnamVal != null && sstaVal != null)
       break;
}
System.out.println("SSTA: " + sstaVal);
System.out.println("PNAM: " + pnamVal);