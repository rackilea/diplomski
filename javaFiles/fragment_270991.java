package stackoverflow.questions.q18943680;

import java.util.ArrayList;

public class Owner {

    String username;
    String password;
    String email;
    String name;
    String _id;
    int  __v;

    ArrayList<String> phones;

    @Override
    public String toString() {
        return "Owner [username=" + username + ", password=" + password
                + ", email=" + email + ", name=" + name + ", _id=" + _id
                + ", __v=" + __v + ", phones=" + phones + "]";
    }

}