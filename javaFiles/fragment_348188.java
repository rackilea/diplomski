@Data
@Entity
@Table(name = "users")
public class User {
    private static final String USER_SESSION_ID = "sessionId";

    @Id
    Long id;

    String login;
    String password;
    String email;

    Integer role;

    public static User authUser(User user) {
        return Ebean.find(User.class).where()
                .eq("login", user.login)
                .eq("password", user.password)
                .findUnique();
    }

    public static void addAuthenticatedUser(Request req, User u) {
        Session session = req.session();
        Ebean.save(new UserSession(u, session.id()));
        req.session().attribute(USER_SESSION_ID, u);
    }

    public static User getAuthenticatedUser(Request req, Response res) {
        User user = null;
        Session session = req.session(false);
        if (session == null) {
            UserSession userSession = UserSession.getSession(req.cookies().get("JSESSIONID"));
            if (userSession != null) {
                user = userSession.getUser();
                userSession.delete();
                addAuthenticatedUser(req, user);
            }
        } else {
            user = session.attribute(USER_SESSION_ID);
        }

        // Redirect to login form
        if (user == null) {
            res.redirect("/login");
            halt();
        }
        return user;
    }
}