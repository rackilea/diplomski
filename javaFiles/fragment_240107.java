public static boolean isSet(String s){
     if(s==null || "".equals(s)) return false;
     return true;
}
//.... your validation here
if(isSet(user) && isSet(pass) && isSet(conPass) && pass.equals(conPass)){
    //create account
}else{
  //smth wrong eg. if(!pass.equals(conPass) { //wrongpass }
}