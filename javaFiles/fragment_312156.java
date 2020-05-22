public class HelloWorld {

    public static void main(String args[]) {

        String json = "{'id': 1,'name': 'Abc','isOnline': True}";
        User user = new Gson().fromJson(json, User.class);
        System.out.println(user);
    }

}

class User {

    private String id;
    private String name;
    private boolean isOnline;

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", isOnline=" + isOnline
                + "]";
    }
}