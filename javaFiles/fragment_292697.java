public static void  login(String userCode,String password){        
    User loginUser = User.find("byUserCodeAndPassword",userCode,password).first();
    if(loginUser == null){
        flash.put("username",userCode);
        flash.error("Invalid Credentials");
        index();
    }
    else{
        Cache.set(session.getId(),loginUser,"20mn");
        Home.Home();
    }
}