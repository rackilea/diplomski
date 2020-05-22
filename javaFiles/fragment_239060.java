PoolingHttpClientConnectionManager cm = new   PoolingHttpClientConnectionManager();
CloseableHttpClient httpClient = HttpClients.custom()
            .setConnectionManager(cm)
            .build();

private final ExecutorService pool = Executors.newFixedThreadPool(poolSize);

for (int i = 0; i < missingUIDList.size(); i++) {
    HttpGet get = new HttpGet("https://api.guildwars2.com/v2/items/" + missingUIDList.get(i));
    pool.execute(new Worker(get));
}

class Worker implements Runnable {
    private final HttpGet get;
    private final CloseableHttpClient httpClient;
    Handler(CloseableHttpClient httpClient,HttpGet get) { 
        this.get = get;
        this.httpClient = httpClient;
    }
    public void run() {
        try {
            HttpResponse response = client.execute(get);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            httpJSONObject = new JSONObject(result);
            ....
            //rest of your code
            ....
            statement.executeUpdate(cookie);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}