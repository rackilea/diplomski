SOAPHeaderElement header=new SOAPHeaderElement("http://tempuri.org/","Authentication");
    //**set the prefix met, though not necessary, the parser will default it to ns1 or something**/
    header.setPrefix("met");
    /**Add the username Node**/
    SOAPElement user=header.addChildElement("userName");
    /**Add the userName text**/
    user.addTextNode("MyName");
    /**Add the password node**/
    SOAPElement password=header.addChildElement("password");
    /**Add the password text**/
    password.addTextNode("myPass");
    /** Print the header if you wish to**/
    System.out.println(header);     
    /**set the header to stub, that's all, I think, you may setActor and mustunderstand**/
    _stub.setHeader(header);