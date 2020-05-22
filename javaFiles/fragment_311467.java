public class Signup {

public void settingPassowrd(){

    Users  user1 =new Users();
    user1.setapassword("player"); 

    SendMail mail1 =new SendMail(user1);
    mail1.Sendsmail();

}
}