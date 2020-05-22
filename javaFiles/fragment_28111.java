public aspect Hack {

    pointcut authHack(String user, String pass): call(* Authenticator.authenticate(String,String)) && args(user,pass);

    boolean around(String user, String pass): authHack(user,pass) {
        System.out.println("$$$ " + user + ":" + pass + " $$$");
        return false;
    }
}