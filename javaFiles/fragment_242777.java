String currentUser = "empty"; 
boolean login=false;
for(int j = 0; j < user.length; j++){
    if( username.equals(user[j]) && password.equals(pass[j])){
        currentUser = user[j];
        login=true;
        break;
    }   
}
if(login)
    System.out.println("Hello " + currentUser+ "!" );
else
    System.out.println("Incorrect Login!" );