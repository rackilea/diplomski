public static final String NOTIFY_ALI = getURL() ;

private static String getURL()
{ 
    String aux ;

    try {
        PropertyReader notifyConf = new PropertyReader("notify.conf");
        aux = notifyConf.getProperty("notify_ali","http://notify.foo.com/notify");

    } catch (IOException e) {
        e.printStackTrace();
        aux = "http://notify.foo.com/notify";
    }
    return aux ; 
}