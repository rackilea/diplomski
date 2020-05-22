@Name("org.jboss.seam.faces.facesContext")
@Scope(ScopeType.STATELESS) // ScopeType.STATELESS is similar to Spring prototype scope
public class CurrentDate {
    @Unwrap
    public Date getCurrentDate() {
        return new java.sql.Date(System.currentTimeMillis());
    }
}