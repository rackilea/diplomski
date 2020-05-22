@WebFault(faultBean = 'com.company.services.FaultBean')
public class NoCompanyFoundException extends Exception {
    private FaultBean faultBean;
    //getters, setters, etc
}

public class FaultBean {
    // message and error code are totally arbitrary, other fields could be used
    private String message;
    private String errorCode;
}