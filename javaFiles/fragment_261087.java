public class Jackson {
    public static void main(String[] args) throws Exception {
        String json = "{\"userId\": \"021\", \"userAge\": 99}";
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(json, User.class);
        System.out.println(user.userId);
    }
}

class User {
    int userId;
    int userAge;
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }
}