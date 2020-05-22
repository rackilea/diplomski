StringBuilder sb = new StringBuilder();
sb.append("code=").append(code)
    .append("&client_id=").append(GoogleStrategy.clientId)
    .append("&client_secret=").append( GoogleStrategy.clientSecret)
    .append("&redirect_uri=").append(GoogleStrategy.redirectUri)
    .append("&grant_type=").append(GoogleStrategy.grantType)

requestHolder.setContentType("application/x-www-form-urlencoded")
    .post(sb.toString());