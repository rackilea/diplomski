try{
   //connect to mail server
    System.out.println("Ok");
}
catch(javax.mail.AuthenticationFailedException e)
{
    //display connection error to the user, maybe allow them to retry
    System.out.println("Sorry your credentials are incorrect");
}