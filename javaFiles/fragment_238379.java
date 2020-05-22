String client_id = "<APP_ID>";
String client_secret = "<CLIENT_SECRET>";
String redirectUrl = "http://127.0.0.1:5080/Red5FacebookAuth/oauth/oauth_redirect"; 
OAuth2ServiceProvider provider = new OAuth2ServiceProvider("https://graph.facebook.com/oauth/authorize", "https://graph.facebook.com/oauth/access_token");
OAuth2Consumer consumer = new OAuth2Consumer(client_id, client_secret, provider);


//Using HttpServletResponse (but you can kickstart it through an Action/Controller/etc.
response.sendRedirect(consumer.generateRequestAuthorizationUrl(ResponseType.CODE, redirectUrl, null, ",", (String[])null)); //where null is the scope array,