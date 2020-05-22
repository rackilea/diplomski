/**
 * Forgets the current session token.
 *
 * @return The current {@code Service} instance.
 */
public Service logout() {
    this.token = null;
    this.removeAllCookies();
    return this;
}