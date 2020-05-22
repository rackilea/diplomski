/**
 * Create bind principal by appending configured user domain to username if it doesn't already contain a domain.
 *
 * @param username  User name for which to create bind principal.
 *
 * @return username, if configured domain is null or the username already contains a domain; otherwise username
 *         appended with the configured user domain.
 */
String createBindPrincipal(final String username) {
    if (domain == null || username.contains("@")) {
        return username;
    }
    return username + "@" + userDomain;
}