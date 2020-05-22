private String getUsername(){

    String userName = firstName.substring(0,1).toLowerCase() + lastName.toLowerCase();
    int i=1;
    while(usernameExists(userName)){
        userName = userName.replaceAll("\\d+$","") + i++;
    }
    return userName;
}