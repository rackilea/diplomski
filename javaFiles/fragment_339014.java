package com.jraw;

import net.dean.jraw.RedditClient;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.http.oauth.Credentials;
import net.dean.jraw.http.oauth.OAuthData;
import net.dean.jraw.http.oauth.OAuthException;
import net.dean.jraw.models.Contribution;
import net.dean.jraw.models.Listing;
import net.dean.jraw.paginators.UserContributionPaginator;

public class printSaved {

    public static void main(String [] args) {
        UserAgent myUserAgent = UserAgent.of("desktop", "com.jraw.printSaved", "v0.01", "user");
        RedditClient redditClient = new RedditClient(myUserAgent);
        String username = "username";
        Credentials credentials = Credentials.script(username, "<password>", "<clientId>", "<clientSecret>");

        OAuthData authData = null;
        try {
            authData = redditClient.getOAuthHelper().easyAuth(credentials);
        } catch (OAuthException e) {
            e.printStackTrace();
        }
        redditClient.authenticate(authData);

        UserContributionPaginator saved = new UserContributionPaginator(redditClient,"saved",username);

        Listing<Contribution> savedList = saved.next();

        for (Contribution item : savedList) {
            System.out.println(item);
        }
    }
}