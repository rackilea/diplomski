Set<Integer> signedIn = new LinkedHashSet<>();
...
if (signedIn.add(loginNumber)) {
    // The set was modified, therefore this is a new login
} else {
    // The number was already present, log-off the user.
    signedIn.remove(loginNumber);
}
...
if (signedIn.contains(loginNumber)) {
    // Allow the user to...
} else {
    // Error, user not signed in
}