import com.ibm.websphere.security.NotImplementedException;
import com.ibm.wsspi.security.auth.callback.Constants;
import com.ibm.wsspi.security.auth.callback.WSMappingCallbackHandlerFactory;
import javax.resource.spi.security.PasswordCredential;
import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

Map map = new HashMap();
map.put(Constants.MAPPING_ALIAS, "REPLACE_WITH_YOUR_AUTH_ALIAS");
CallbackHandler callbackHandler = null;
try {
    callbackHandler = WSMappingCallbackHandlerFactory.getInstance().getCallbackHandler(map, null);
} catch (NotImplementedException e) {
}

LoginContext loginContext = null;
try {
loginContext = new LoginContext("DefaultPrincipalMapping", callbackHandler);
    loginContext.login();
} catch (LoginException e) {
}

Subject subject = loginContext.getSubject();
Set credentials = subject.getPrivateCredentials();

PasswordCredential passwordCredential = (PasswordCredential) credentials.iterator().next();

String user = passwordCredential.getUserName();
String password = new String(passwordCredential.getPassword());

response.setContentType("text/html");
PrintWriter out = response.getWriter();
out.println("<h1>User: " + user + " --- Password: " + password+"</h1>");