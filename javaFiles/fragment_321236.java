LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF); 
java.util.logging.Logger.getLogger("org.apache.commons.httpclient").setLevel(Level.OFF);

client = new WebClient(BrowserVersion.CHROME);
client.getOptions().setJavaScriptEnabled(true);
client.getOptions().setThrowExceptionOnScriptError(false);
client.getOptions().setThrowExceptionOnFailingStatusCode(false);