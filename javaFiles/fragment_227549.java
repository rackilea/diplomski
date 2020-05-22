public class SessionBean implements Serializable{
    private static final long serialVersionUID = -867309384910092832L;

    private int     userRole;
    private int     userId;
    private String          userName;

    public boolean isLoggedIn ()
    {
        return userId>0 ;   
    }
}