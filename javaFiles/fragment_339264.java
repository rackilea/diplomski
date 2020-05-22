import com.ibm.wsspi.security.auth.callback.Constants;
import com.ibm.wsspi.security.auth.callback.WSMappingCallbackHandlerFactory;
import javax.resource.spi.security.PasswordCredential;
import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
...
Map map = new HashMap();
map.put(Constants.MAPPING_ALIAS, YOUR_J2C_AUTHENTICATION_ALIAS);
CallbackHandler callbackHandler = null;
try {
    callbackHandler = WSMappingCallbackHandlerFactory.getInstance().getCallbackHandler(map, null);
} catch (NotImplementedException e) {
    logger.error(e);
    return;
}
LoginContext loginContext;
try {
    loginContext = new LoginContext("DefaultPrincipalMapping", callbackHandler);
} catch (LoginException e) {
logger.error(e);
return;
}
try {
    loginContext.login();
} catch (LoginException e) {
    logger.error(e);
    return;
}
Subject subject = loginContext.getSubject();
Set credentials = subject.getPrivateCredentials();
PasswordCredential passwordCredential = (PasswordCredential) credentials.iterator().next();
Properties props = new Properties();
props.setProperty(AdminClient.CONNECTOR_HOST, "localhost");
props.setProperty(AdminClient.CONNECTOR_PORT, port); //2809
props.setProperty(AdminClient.CONNECTOR_TYPE, AdminClient.CONNECTOR_TYPE_RMI);
props.setProperty(AdminClient.CONNECTOR_SECURITY_ENABLED, "true");
props.setProperty(AdminClient.USERNAME, passwordCredential.getUserName());
props.setProperty(AdminClient.PASSWORD, new String(passwordCredential.getPassword()));
adminClient = AdminClientFactory.createAdminClient(props);