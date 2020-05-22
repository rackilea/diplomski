@Data
@Entity
@Table(name = "sessions")
public class UserSession {

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "uid")
    private User user;
    private String session;
    private Timestamp taken;

    public UserSession(User u, String sessionId) {
        user = u;
        session = sessionId;
        taken = new Timestamp(System.currentTimeMillis());
    }

    public static UserSession getSession(String session) {
        return Ebean.find(UserSession.class).where().eq("session", session).findUnique();
    }

    public void delete() {
        SqlUpdate deleteQuery = Ebean.createSqlUpdate("DELETE FROM sessions WHERE uid = :uid AND session = :session");
        deleteQuery.setParameter("uid", user.id);
        deleteQuery.setParameter("session", session);
        deleteQuery.execute();
    }
}