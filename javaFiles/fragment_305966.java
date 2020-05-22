public static InetAddress getExternalIp() throws IOException {
    URL url = new URL("http://automation.whatismyip.com/n09230945.asp");
    URLConnection connection = url.openConnection();
    connection.addRequestProperty("Protocol", "Http/1.1");
    connection.addRequestProperty("Connection", "keep-alive");
    connection.addRequestProperty("Keep-Alive", "1000");
    connection.addRequestProperty("User-Agent", "Web-Agent");

    Scanner s = new Scanner(connection.getInputStream());
    try {
        return InetAddress.getByName(s.nextLine());
    } finally {
        s.close();
    }
}