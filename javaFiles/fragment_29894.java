public static String getLoginUrl() {
    return DOMAIN + "login/";
}
public static String getUserProfileUrl() {
    return DOMAIN + "user/";
}
public static String getVenueListUrl(String lat, String lng, String radius) {
    String str = DOMAIN + "venues/?centre_lat=#@#&centre_lon=#@@#&radius=#@@@#";
    // ...
}