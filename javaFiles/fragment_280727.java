public class User { // use java naming conventions 
    private IntegerProperty userId;

    public int getUserId() { return this.userId.get(); }
    public void setUserId(int userId) { this.userId.set(userId); }
    public IntegerProperty userIdProperty() { return this.userId; }

    private StringProperty userName;

    public String getUserName() { return this.userName.get(); }
    public void setUserName(String userName) { this.userName.set(userName); }
    public StringProperty userNameProperty() {return this.userName; }

    public User(int userId,String userName){
         this.userId = new SimpleIntegerProperty(userId);
         this.userName = new SimpleStringProperty(userName);
    }
}