AuthCache authCache = new BasicAuthCache();

AuthScheme basicAuthScheme = null;
if (isProxy) {
   basicAuthScheme = new BasicScheme(ChallengeState.PROXY);
} else {
   basicAuthScheme = new BasicScheme(ChallengeState.TARGET);
}

authCache.put(host, basicAuthScheme);
httpContext.setAttribute(ClientContext.AUTH_CACHE, authCache);