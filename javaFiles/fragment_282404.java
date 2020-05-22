//This matches if the request has X-Operation-Name header and its value is forgot-password
RequestHeaderRequestMatcher headerMatcher = new RequestHeaderRequestMatcher("X-Operation-Name","forgot-password" );

// This matches if the request is POST to the /api/website-user
AntPathRequestMatcher antRequestMatcher = new AntPathRequestMatcher("/api/website-user", HttpMethod.POST)

// This matches if both of the above matches matches 
AndRequestMatcher andMatcher = new AndRequestMatcher(headerMatcher,antRequestMatcher );

httpSecurity.authorizeRequests().requestMatchers(andMatcher).permitAll();