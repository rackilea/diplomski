import org.cometd.bayeux.server.BayeuxServer;
import org.cometd.bayeux.server.ServerMessage;
import org.cometd.bayeux.server.ServerSession;
import org.cometd.server.DefaultSecurityPolicy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

public class BayeuxAuthenticator extends DefaultSecurityPolicy implements ServerSession.RemoveListener {

    // (...)

    @Override
    public boolean canHandshake( BayeuxServer server, ServerSession session, ServerMessage message ) {
        SecurityContextHolder.getContext().setAuthentication( ( UsernamePasswordAuthenticationToken ) message.getBayeuxContext().getUserPrincipal() );
        String user = securityService.getUserName();
        // (...)

        return true;
    }

    // (...)
}