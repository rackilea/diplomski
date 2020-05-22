private static void loadCookieIfPresent() {
    Http.Cookie remember = request.cookies.get("rememberme");
    if (remember != null && remember.value.indexOf("-") > 0) {
        String sign = remember.value.substring(0, remember.value.indexOf("-"));
        String username = remember.value.substring(remember.value.indexOf("-") + 1);
        if (Crypto.sign(username).equals(sign)) {
            session.put("username", username);
        }
    }
}