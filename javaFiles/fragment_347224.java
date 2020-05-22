public OAuth2AccessToken readAccessToken(String tokenValue) {
Pattern pattern = Pattern.compile(HRN_REGEX);
Matcher matcher = pattern.matcher(tokenValue);
OAuth2AccessToken oAuth2AccessToken = super.readAccessToken(tokenValue);
if (oAuth2AccessToken == null && matcher.find()) {
    String group = matcher.group();
    String companyStr = group.replace(LICENCE_TOKEN_PREFIX, "");
    Long companyId= Long.valueOf(companyStr);
    boolean isCompanyValid = mLoginUserService.validateCompanyIdForAnonymousLogin(companyId);
    if (isCompanyValid) {
        OAuth2Request storedReq = new OAuth2Request(generateDummyReqParameters(), CLIENT, null, true, generateScope(), generateResourceIds(), null, null, null);
        Authentication userAuth = new AnonymousAuthenticationToken(companyStr, companyId, AuthorityUtils.createAuthorityList(ROLE_COMPANY));
        OAuth2Authentication authentication = new OAuth2Authentication(storedReq, userAuth);
        storeAccessToken(new DefaultOAuth2AccessToken(tokenValue), authentication);
        return new DefaultOAuth2AccessToken(tokenValue);
    } else {
        throw new InvalidTokenException(COMPANY_IS_NOT_LICENCED);
    }
}
return oAuth2AccessToken;}