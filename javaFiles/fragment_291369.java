//load full user info (custom method)
UserDetails userDetails = placeUserDetailsService.loadUserByUsername(responseUser.getEmail());

            Set<String> scope = new HashSet<>();
            scope.add("read"); scope.add("write");
            OAuth2Request auth2Request = new OAuth2Request(null, "smthg", userDetails.getAuthorities(), true,
                    scope, null, null, null, null);
    //Custom OAuth2Token
            PlaceAuthenticationToken placeAuthenticationToken = new PlaceAuthenticationToken(userDetails, userDetails.getAuthorities());
            placeAuthenticationToken.setAuthenticated(true);
            placeAuthenticationToken.setDetails(new WebAuthenticationDetails(request));

            OAuth2Authentication auth = new OAuth2Authentication(auth2Request, placeAuthenticationToken);
            auth.setAuthenticated(true);
            auth.setDetails(placeAuthenticationToken.getDetails());
            accessToken =  authServer.createAccessToken(auth);

            DefaultOAuth2AccessToken tkn = (DefaultOAuth2AccessToken) accessToken;
            tkn.setRefreshToken(null);
            accessToken = tkn;