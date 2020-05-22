import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class AuthenticatedRequest extends HttpServletRequestWrapper {

    private int userId;

    public AuthenticatedRequest(HttpServletRequest req, int userId) {
        super(req);
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

}