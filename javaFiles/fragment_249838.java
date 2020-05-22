/**
 * Extends duration of a webToken {@link de.core.model.security.WebToken}.
 * 
 * The <code>newDate</code> variable defines ...
 *
 * @param webToken to extend webtokens duration.
 */
public void extendDuration(@NonNull WebToken webToken) {
    WebToken webtokenObj = getWebToken(webToken.getToken());
    LocalDateTime newDate = LocalDateTime.now().plusHours(WebToken.EXPIRE_ADJUSTER);
    webtokenObj.setExpireDate(newDate);
    em.merge(webtokenObj);
}