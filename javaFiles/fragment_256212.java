private static LoadingCache<String, MyPrincipal> tokenCacheMap;

@PostConstruct
private void postConstruct() {
    tokenCacheMap = CacheBuilder.newBuilder()
            .expireAfterAccess(15, TimeUnit.MINUTES)
            .build(
                    new CacheLoader<String, MyUserPrincipal>() {
                        @Override
                        public MyUserPrincipal load(String token) {
                            MyUserPrincipal myUserPrincipal = getUserFromToken(token);

                            if( myUserPrincipal != null ) {
                                myUserPrincipal.setToken(token);
                                return myUserPrincipal;
                            }

                            throw new SecurityException("token is not valid");
                        }
                    }
            );
}

//
// later in the code...
//
MyUserPrincipal myUserPrincipal = tokenCacheMap.get(token);