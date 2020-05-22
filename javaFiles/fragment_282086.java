public class Global extends Application {

    private static Global instance;
    private String username;

    @Override
    public void onCreate() {
      super.onCreate();
      instance = this;
    }

    public static Global getInstance() {
      return instance;
    }

    public String GetUsername(){
        return username;
    }

    public void SetUsername (String username){
        this.username = username;
    }

}