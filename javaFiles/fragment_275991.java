package net.sghill.example;

import net.sghill.example.UserDeserializer
import net.sghill.example.UserSerializer
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonDeserialize(using = UserDeserializer.class)
public class User {
    private ObjectId id;
    private String   username;
    private String   password;

    public User(ObjectId id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public ObjectId getId()       { return id; }
    public String   getUsername() { return username; }
    public String   getPassword() { return password; }
}