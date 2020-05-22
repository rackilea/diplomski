package misc.user;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Michael
 * Creation date 8/5/2017.
 * @link https://stackoverflow.com/questions/45524768/java-unit-testing-help-for-loop
 */
public class User {

    private final String username;
    private final String password;

    public User(String username, String password) {
        if (StringUtils.isBlank(username)) throw new IllegalArgumentException("username cannot be blank or null");
        if (StringUtils.isBlank(password)) throw new IllegalArgumentException("password cannot be blank or null");
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        User user = (User) o;

        if (!getUsername().equals(user.getUsername())) { return false; }
        return getPassword().equals(user.getPassword());
    }

    @Override
    public int hashCode() {
        int result = getUsername().hashCode();
        result = 31 * result + getPassword().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "{\"User\":{"
                + "\"username\":\"" + username + "\""
                + ",\"password\":\"" + password + "\""
                + "}}";
    }
}