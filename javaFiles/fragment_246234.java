//set HttpOnly properties for all cookies
for (String key : cookies.keySet()) {
    if (key != null) {
        response.removeCookie(key);
        response.cookie("/", key, cookies.get(key), 200, false, true);
    }
}