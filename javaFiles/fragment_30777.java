String code =  request.getParameter("code");
    String foros = "code="+code +
                "&client_id=<YOUR_CLIENT_ID>" +
                "&client_secret=<YOUR_CLIENT_SECRET>" +
                "&redirect_uri="+getText("google.auth.redirect.uri") +
                "&grant_type=authorization_code";