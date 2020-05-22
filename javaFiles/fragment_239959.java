public class User {
    private String id, name, email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

public static void main(String[] args) {
    String result = ""
            + "{\"0\": {    \"id\": 1,    \"name\": \"Some Guy\",    \"email\": \"example1@example.com\"},"
            + "\"1\": {    \"id\": 2,    \"name\": \"Person Face\",    \"email\": \"example2@example.com\"}"
            + "}";

    Gson gson = new Gson();

    Type hashMapType = new TypeToken<HashMap<String, User>>() {
    }.getType();
    HashMap<String, User> users = gson.fromJson(result, hashMapType);
    for (String key : users.keySet()) {
        printUser(users.get(key));
    }
}

private static void printUser(User user) {
    System.out.printf("%s %s %s\n", user.getId(), user.getName(),
            user.getEmail());
}