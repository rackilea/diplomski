public class User{

    @SerializedName("name")
    private String userName;
    @SerializedName("age")
    private Integer userAge;

    public User(String name, Integer age){
        userName = name;
        userAge = age;
    }
}