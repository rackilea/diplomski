class FbprojectApplication extends Application{
   static UserObject user;

    public static void setUserObject(UserObject user){
      this.user=user;
    }

    public static UserObject getUserObject(){
       return user;
    }

}