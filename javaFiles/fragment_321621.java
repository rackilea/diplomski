public boolean retrieveLoginData(LoginRecord lr) {

for(int i = 0; i<login.size(); i++){
    if(login.get(i).getLoginName.equals(lr.getLoginName)){
        return true;
    }
}
return false;
}