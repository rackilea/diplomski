public class UserInformation {
    private String name, email, phoneNum;

    public UserInformation() {}

    public UserInformation(String name, String email, String phoneNum) {
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhoneNum() { return phoneNum; }
}