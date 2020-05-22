public class WebClient {

    private final OkHttpClient httpClient;
    private static WebClient webClient;

    private WebClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if (Configurator.getInstance().useProxy()) {
            CodeUtils.setProxy();
            builder.proxySelector(new CustomProxySelector());
            builder.proxyAuthenticator(new CustomProxyAuthenticator());
        } else {
            builder.proxy(Proxy.NO_PROXY);
            CodeUtils.removeProxy();
        }

        httpClient = builder
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    public static WebClient getInstance() {
        return webClient != null ? webClient : (webClient = new WebClient());
    }

    public static void reload() {
        webClient = null;
    }

    public String doGet(String url) throws IOException {
        Request httpRequest = new Request.Builder().url(url).build();
        Response httpResponse = httpClient.newCall(httpRequest).execute();

        if (httpResponse.code() != 200) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success", false);
            jsonObject.put("msg", httpResponse.body().string());
            jsonObject.put("httpCode", httpResponse.code());
            return jsonObject.toString();
        }

        return httpResponse.body().string();
    }

    public String doPost(String url, JSONObject body) throws IOException {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), body.toString());
        Request request = new Request.Builder()
                .header("Accept", "application/json")
                .header("Content-type", "application/json; charset=UTF-8")
                .url(url)
                .post(requestBody).build();
        Response response = httpClient.newCall(request).execute();
        return response.body().string();
    }
}