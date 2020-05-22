@Stateless
public class TokenFetcher

    @Resource
    private SessionContext sessionContext;

    @RolesAllowed("SYSTEM")
    public Token getToken() {
        return (Token) sessionContext.lookup("token");
    }
}