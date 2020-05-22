public class User {
    private static final User[] users = new User[2];
    static {
         user[0] = new User(0, "Action_0");
         user[1] = new User(1, "Action_1");
    }

    private final int id;
    private final String action;

    public User(int id, String action){
          this.id = id;
          this.action = action;
    }

    public int getId(){
           return this.id;
    }

    public Intent getIntent(){
           Intent intent = new Intent();
           intent.setAction(this.action);
           return intent;
    }

    public static User getUser(int id){
        for(int i=0; i < users.length; i++){
             User user = user[i];
             if(id == user.getId()){
                 return user;
             }
        }
        throw new Resources.NotFoundException("User not found with id: "+id);
    }

}