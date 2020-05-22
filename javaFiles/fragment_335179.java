public class User {
     @Expose private String firstName;
     @Expose(serialize = false) private String lastName;
     @Expose (serialize = false, deserialize = false) private String emailAddress;
     private String password;
 }