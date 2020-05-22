public static final InitVariables IV = initVariables() ;

public class InitVariables {
    String NOTIFY_ALI ;
    String CONTACT_EMAIL ;
    int numEmployees ; 
}

private static InitVariables initVariables()
{ 
    InitVariables iv ;

    iv = new InitVariables() ;

    try {
        PropertyReader notifyConf = new PropertyReader("notify.conf");
        aux = notifyConf.getProperty("notify_ali","http://notify.foo.com/notify");

    } catch (IOException e) {
        e.printStackTrace();
        aux = "http://notify.foo.com/notify";
    }

    iv.NOTIFY_ALI = aux ;

    iv.CONTACT_EMAIL = "you@somedomain.com";
    iv.numEmployees = 0 ;

    return iv ; 
}