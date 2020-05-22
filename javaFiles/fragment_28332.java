// split scope params
String[] scopeStrings = scope.split("\\+|_|__");

Scope firstScope = new Scope(scopeStrings[0]);
Scope[] scopes = new Scope[scopeStrings.length - 1];
for (int i = 1; i < scopeStrings.length; i++) {
    scopes[i - 1] = new Scope(scopeStrings[i]);
}

GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestServerAuthCode(this.getString(R.string.auth_client_id))
            .requestScopes(firstScope, scopes)
            .requestEmail()
            .requestProfile()
            .build();