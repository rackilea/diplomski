ConnectionConfiguration config = new ConnectionConfiguration("chat.facebook.com", 5222);
config.setSASLAuthenticationEnabled(true);
XMPPConnection xmpp = new XMPPConnection(config);
try
{
    SASLAuthentication.registerSASLMechanism("X-FACEBOOK-PLATFORM", SASLXFacebookPlatformMechanism.class);
    SASLAuthentication.supportSASLMechanism("X-FACEBOOK-PLATFORM", 0);
    xmpp.connect();
    xmpp.login(apiKey + "|" + sessionKey, sessionSecret, "Application");
} catch (XMPPException e)
{
    xmpp.disconnect();
    e.printStackTrace();
}