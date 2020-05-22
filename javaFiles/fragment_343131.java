public class MobileCheck extends ActionSupport {
    public String execute() throws Exception{
        log.debug("MobileCheck execute() should never be invoked");
        return SUCCESS;
    }

    public String mobileView() throws Exception{
        // do something
        log.debug("mobileView() business performed");
        return execute(); /* THIS IS THE TRICK */ 
    }
}

public class ActionA extends MobileCheck {
    public String execute() throws Exception{
        // do something
        log.debug("ActionA execute() is invoked");
        return SUCCESS;
    }
}

public class ActionB extends MobileCheck {
    public String execute() throws Exception{
        // do something
        log.debug("ActionB execute() is invoked");
        return SUCCESS;
    }
}