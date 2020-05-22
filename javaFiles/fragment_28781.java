package com;

public class Sshexample {
    private String callconst = "DEAFULT DATA TO DISPLAY";

    public String getCallconst() {
        return callconst;
    }

    public void setCallconst(String callconst) {
        this.callconst = callconst;
    }


}



Access the property like below code.
 <jsp:useBean id="link" class="com.Sshexample" scope="request">          
        </jsp:useBean>

<html>  
<body>  
Data from java class :: <jsp:getProperty name="link" property="callconst"/>  

</body></html>