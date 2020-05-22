public void someMethod(SecureData sd) {
 String UserNameLog = sd.getUserName();
    String PassLog = sd.getPassword();
    System.out.println(PassLog);

    String pidviduser;
    String pidvidpass;

    //cREATING hval2 NOW
    pidvidpass = PIDstring+":"+VIDstring + ":" +PassLog;
}