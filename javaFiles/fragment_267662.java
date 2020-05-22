// Scope for reading user's contacts
private static final String YOUTUBE_SCOPE = "https://www.googleapis.com/auth/youtube";

...

// Configure sign-in to request the user's ID, email address, basic profile,
// and readonly access to contacts.
GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestScopes(new Scope(YOUTUBE_SCOPE))
        .requestEmail()
        .build();