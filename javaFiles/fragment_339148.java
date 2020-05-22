package de.scrum_master.app;

import java.util.HashMap;
import java.util.Map;

public class UserDB {
    public static enum Role { admin, user, guest }
    public static enum Action { login, logout, read, write }
    public static enum Error { successful_login, user_inactive, invalid_password, unknown_user }

    private static class UserInfo {
        String password;
        Role role;
        boolean active;

        public UserInfo(String password, Role role, boolean active) {
            this.password = password;
            this.role = role;
            this.active = active;
        }
    }

    private static Map<String, UserInfo> knownUsers = new HashMap<>();

    static {
        knownUsers.put("bruce",   new UserInfo("alm1GHTy", Role.admin, true));
        knownUsers.put("john",    new UserInfo("LetMe_in", Role.user,  true));
        knownUsers.put("jane",    new UserInfo("heLL0123", Role.guest, true));
        knownUsers.put("richard", new UserInfo("dicky",    Role.user,  false));
        knownUsers.put("martha",  new UserInfo("paZZword", Role.admin, false));
    }

    public static class UserDBException extends Exception {
        private static final long serialVersionUID = 7662809670014934460L;

        public final String userId;
        public final Role role;
        public final Action action;
        public final Error error;

        public UserDBException(String userId, Role role, Action action, Error error, String message) {
            super(message);
            this.userId = userId;
            this.role = role;
            this.action = action;
            this.error = error;
        }
    }

    public static boolean isKnown(User user) {
        return knownUsers.get(user.getId()) != null;
    }

    public static boolean isActive(User user) {
        return isKnown(user) && knownUsers.get(user.getId()).active;
    }

    public static boolean isPasswordValid(User user) {
        return isKnown(user) && knownUsers.get(user.getId()).password.equals(user.getPassword());
    }

    public static Role getRole(User user) {
        return isKnown(user) ? knownUsers.get(user.getId()).role : null;
    }

    public static void login(User user) throws UserDBException {
        String userId = user.getId();
        if (!isKnown(user))
            throw new UserDBException(
                userId, getRole(user), Action.login,
                Error.unknown_user, "Unknown user"
            );
        if (!isActive(user))
            throw new UserDBException(
                userId, getRole(user), Action.login,
                Error.user_inactive, "Inactive " + getRole(user)
            );
        if (!isPasswordValid(user))
            throw new UserDBException(
                userId, getRole(user), Action.login,
                Error.invalid_password, "Invalid " + getRole(user) + " password"
            );
    }
}