/**
 * Extends duration of a webToken {@link de.core.model.security.WebToken}.
 *
 * @param webToken to extend webtokens duration.
 */
public void extendDuration(@NonNull WebToken webToken) {
    WebToken webtokenObj = getWebToken(webToken.getToken());
    // the significance of the variable is ...
    LocalDateTime newDate = LocalDateTime.now().plusHours(WebToken.EXPIRE_ADJUSTER);
    webtokenObj.setExpireDate(newDate);
    em.merge(webtokenObj);
}