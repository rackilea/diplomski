public static boolean validateusername (String username, ArrayList<String>UsernameList){
    if(username.isEmpty()){

        System.out.println("Username cannot be empty");
        return false;

        }

    else if(!username.equals(UsernameList.size())){

        System.out.println("Please input again your username");
        return false;

        }
    return true;

}//validateusername


public static boolean validatepassword(String password, ArrayList<String>PasswordList){

    if(password.isEmpty()){

        System.out.println("Password cannot be empty");
        return false;
        }
    else if(!password.equals(PasswordList.size())){

        System.out.println("Please input again your password");
        return false;

        }

    return true;



}//validatepassword