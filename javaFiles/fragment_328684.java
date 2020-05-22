import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public class User implements KvmSerializable {
    private String email;
    private String firstName;
    private String password;
    private String gplusId ;
    private String tweeterId ;
    private String lastName;
    private String facebookId;

public User() {}

public User(String email, String firstName, String password, String gplus, String tweet, String lastName, String facebook) {
    this.email = email;
    this.firstName = firstName;
    this.password = password;
    this.gplusId = gplus;
    this.tweeterId = tweet;
    this.lastName = lastName;
    this.facebookId = facebook;
}

public User(String email, String firstName, String password) {
    this.email = email;
    this.firstName = firstName;
    this.password = password;
}

public void setEmail(String email) { this.email = email; }
public void setFirstName(String firstName) { this.firstName = firstName; }
public void setPassword(String password) { this.password = password; }
public void setGplusId(String gplusId) { this.gplusId = gplusId; }
public void setTweet(String tweeterId) { this.tweeterId = tweeterId; }
public void setLastName(String lastName) { this.lastName = lastName; }
public void setFacebookId(String facebookId) { this.facebookId = facebookId; }



public String getEmail() { return email;}
public String getFirstName() { return firstName;}
public String getPassword() { return password;}
public String getGplusId() { return gplusId;}
public String getTweet() { return tweeterId;}
public String getLastName() { return lastName;}
public String getFacebookId() { return facebookId;}

public Object getProperty(int arg0) {
    switch(arg0) {
        case 0:
            return email;
        case 1:
            return firstName;
        case 2:
            return password;
        case 3:
            return gplusId;
        case 4:
            return tweeterId;
        case 5:
            return lastName;
        case 6:
            return facebookId;
     }
     return null;
}

public int getPropertyCount() {
    return 7;
}

public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo propertyInfo) {
    switch(index)
    {
        case 0:
            propertyInfo.name = "email";
            propertyInfo.type = PropertyInfo.STRING_CLASS;
            break;
        case 1:
            propertyInfo.name = "firstName";
            propertyInfo.type = PropertyInfo.STRING_CLASS;
            break;
        case 2:
            propertyInfo.name = "password";
            propertyInfo.type = PropertyInfo.STRING_CLASS;
            break;
        case 3:
            propertyInfo.name = "gplusId";
            propertyInfo.type = PropertyInfo.STRING_CLASS;
            break;
        case 4:
            propertyInfo.name = "tweeterId";
            propertyInfo.type = PropertyInfo.STRING_CLASS;
            break;
        case 5:
            propertyInfo.name = "lastName";
            propertyInfo.type = PropertyInfo.STRING_CLASS;
            break;
        case 6:
            propertyInfo.name = "facebookId";
            propertyInfo.type = PropertyInfo.STRING_CLASS;
            break;
        default:
            break;
    }
}

public void setProperty(int index, Object value) {
    switch(index) {
        case 0:
            this.email = value.toString();
            break;
        case 1:
            this.firstName = value.toString();
            break;
        case 2:
            this.password = value.toString();
            break;
        case 3:
            this.gplusId = value.toString();
            break;
        case 4:
            this.tweeterId = value.toString();
            break;
        case 5:
            this.lastName = value.toString();
            break;
        case 6:
            this.facebookId = value.toString();
            break;
        default:
            break;
   }
}
}