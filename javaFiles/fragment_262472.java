public String getNumber(String pduString)
{
    Pattern p = Pattern.compile("^2b[0-9abcdefABCDEF]+2f545950453d504c4d4e$");
    Matcher m = p.matcher(pduString);
    return m.find() ? m.group(1) : "";
}

public String getUrl(String pduString)
{
    Pattern p = Pattern.compile("^68747470[0-9abcdefABCDEF]+00$");
    Matcher m = p.matcher(pduString);
    return m.find() ? m.group(1) : "";
}