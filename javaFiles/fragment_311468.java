public class SendMail   {
    private Users user1;
    SendMail(Users user1){
        this.user1 = user1
    }
    public void  sendMail(){
    user1.getpassword(); //getting password 
    System.out.println(user1.getpassword()); // If print here I get null
}
}