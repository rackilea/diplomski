public static boolean isOnline(){
    System.setProperty("http.proxyHost", "failProxyIP");
    System.setProperty("http.proxyPort", "failProxyPort");
    try {
        HttpURLConnection connection = (HttpURLConnection)new URL("http://www.google.com").openConnection();
        connection.connect();
        return true;
    } catch (Exception e) {
        return false;
    }
}

public static void main(String[] args) {
    System.out.println(isOnline()); //prints false
}