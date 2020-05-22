InetSocketAddress proxyAddr = new InetSocketAddress("127.0.0.1", 9050);
Proxy proxyTor = new Proxy(Proxy.Type.SOCKS, proxyAddr);

OkHttpClient.Builder builder = new OkHttpClient.Builder().proxy(proxyTor).connectTimeout(30, TimeUnit.SECONDS);
OkHttpClient client = builder.build();
Request request = new Request.Builder().url(address).build();

try (Response response = client.newCall(request).execute()) {
    result = response.body().string();
} catch (Exception e) {
    e.printStackTrace();
}