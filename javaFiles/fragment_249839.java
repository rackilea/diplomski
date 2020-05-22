/**
 * Extends duration of a webToken {@link de.core.model.security.WebToken}.
 * 
 * @see TheClass#createNewDate
 *
 * @param webToken to extend webtokens duration.
 */
public void extendDuration(@NonNull WebToken webToken) {
    WebToken webtokenObj = getWebToken(webToken.getToken());
    webtokenObj.setExpireDate(newDate);
    webtokenObj.setExpireDate(createNewDate());
    em.merge(webtokenObj);
}

/**
 * add useful Javadoc here
 */
public LocalDateTime createNewDate() {
    return LocalDateTime.now().plusHours(WebToken.EXPIRE_ADJUSTER);
}