public boolean checkLogin(LoginRecord lr) {

for(int i = 0; i<login.size(); i++){
    if(login.get(i).getLoginName().equalsIgnoreCase(lr.getLoginName())){
        return true; // Duplicate exists
    }
}
return false;
}


public boolean checkPassword(LoginRecord lr){
for (int i = 0; i <login.size();i++){
    if(login.get(i).getPass().equalsIgnoreCase(lr.getLoginName())){
        return true; // Duplicate exists
    }
}
return false;
}