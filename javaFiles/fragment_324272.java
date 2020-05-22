public class UUID extends org.postgresql.util.PGobject {
    public static final long serialVersionUID = 668353936136517917L;
    public UUID(String s) throws java.sql.SQLException {
        super();
        this.setType("uuid");
        this.setValue(s);
    }
}