LinkedInOAuthService oauthService = LinkedInOAuthServiceFactory.getInstance()
        .createLinkedInOAuthService(consumerKey, consumerSecret);  
// LinkedInRequestToken requestToken = oauthService.getOAuthRequestToken();
LinkedInRequestToken requestToken = 
        (LinkedInRequestToken) session.getAttribute("requestToken")  
LinkedInAccessToken accessToken = oauthService
    .getOAuthAccessToken(requestToken, verifier);