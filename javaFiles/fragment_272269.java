public String getAuthUrl(String authCode){
  return "https://graph.facebook.com/oauth/access_token?client_id=" +
     WS.encode(id)+"&redirect_uri=" +
     WS.encode(Router.getFullUrl("FBConnect.callback")) +  
     "&client_secret="+WS.encode(secret)+"&code="+WS.encode(authCode.replace("|","%7C"));
}