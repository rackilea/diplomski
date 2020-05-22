import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.log4j.Logger;
import org.apache.ws.security.WSPasswordCallback;


/**
 * <p>
 * Provides a callback handler for use processing outbound/inbound SOAP messages.
 * ClientPasswordHandler sets the password used in the WS-Security UsernameToken 
 * SOAP header.
 * 
 * </p>
 * 
 * Created: Apr 1, 2009
 * @author Jared Knipp
 * 
 */
public final class ClientPasswordHandler implements CallbackHandler {
    protected static Logger log = Logger.getLogger(ClientPasswordHandler.class);

    private static final PropertyManager PROPS = PropertyManager.getInstance();
    private static String PASSWORD = PROPS.getPassword();
    private static boolean IS_PASSWORD_CLEAR = PROPS.getIsClearPassword();

    /**
     * Client password handler call back.  This method is used to provide
     * additional outbound (or could be inbound also) message processing.
     * 
     * Here the method sets the password used in the UsernameToken SOAP security header
     * element in the SOAP header of the outbound message.  For our purposes the clear 
     * text password is SHA1 hashed first before it is hashed again along with the nonce and 
     * current timestamp in the security header.
     */
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        if(log.isDebugEnabled()) { log.debug("Setting password for UsernameToken"); }
        WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];


        // Check to see if the password is already Hashed via SHA1, if not then hash it first
        if(IS_PASSWORD_CLEAR) {
            synchronized(this) {
                PASSWORD = PasswordDigestUtil.doPasswordDigest(PASSWORD);
                IS_PASSWORD_CLEAR = false;
                PROPS.setIsClearPassword(IS_PASSWORD_CLEAR);
                PROPS.setPassword(PASSWORD);
                PROPS.saveProperties();
            }
        }

        pc.setPassword(PASSWORD);
    }
}