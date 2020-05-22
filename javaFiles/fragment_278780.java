TokenResponse getOrCreateFor(String accessTokenKey){
  TokenResponse token = cachedKeys.get(accessTokenKey);
  if (token != null)
    return token;

  synchronized(cachedKeys){
    token = cachedKeys.get(accessTokenKey);
    if (token != null)
      return token;
    return cachedKeys.computeIfAbsent(accessTokenKey,
             key -> service.authenticateWithoutCache());
  }
}