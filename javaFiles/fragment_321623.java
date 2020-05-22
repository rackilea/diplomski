public boolean checkLogin(LoginRecord lr) {

for(int i = 0; i<login.size(); i++){
    if(login.get(i).getLoginName().equalsIgnoreCase(lr.getLoginName()) &&
            login.get(i).getPass().equalsIgnoreCase(lr.getPass())){
        return true; // Duplicate exists
    }
}
return false;
}