Har har = proxyServer.getHar();
try {
    har.getLog().getEntries().removeIf(x-> !x.getRequest().getMethod().equals("POST"));
    har.writeTo(new File("har.json"));
} catch (IOException e) {
    e.printStackTrace();
}