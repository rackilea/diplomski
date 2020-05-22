private String CONSUMER_KEY="XX"; // your consumer key here
private String CONSUMER_SECRET="YY"; // your consumer secret here
private String scopeParams="rw_nus+r_basicprofile";

LinkedInOAuthService oAuthService=LinkedInOAuthServiceFactory
            .getInstance().createLinkedInOAuthService(
                    CONSUMER_KEY,CONSUMER_SECRET, scopeParams);