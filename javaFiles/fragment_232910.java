public String getWebSiteAddress(String text)
{
    Pattern p = Pattern.compile("\\b([a-z0-9]+(-[a-z0-9]+)*\\.)+[a-z]{2,3}\\b");
    Matcher m = p.matcher(text);

    if (m.find()) {
        System.out.println("got it");
        return  m.group(1) ;
    }
    else
    {
        System.out.println("didnt get");
        return "";
    }
}