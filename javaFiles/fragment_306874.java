final CloseableHttpAsyncClient client = HttpAsyncClients.createDefault();
client.start();
URL url = new URL("http://www.myurl.com");

StringBuilder sb = new StringBuilder();
for (Map.Entry<String, String> param:params.entrySet()) {
    sb.append(param.getKey()+"="+param.getValue()+"&");
}

if (sb.length() > 0) {
    sb = new StringBuilder(sb.substring(0, sb.length()-1));
}

try {
    HttpAsyncRequestProducer prod = HttpAsyncMethods.createPost(
        BASE_URL+call, 
        sb.toString(), 
        ContentType.APPLICATION_FORM_URLENCODED
    );
    final Future<Boolean> future = client.execute(
        prod, 
        new MyResponseConsumer(),
        null
    );
    NotifierThread hilo = new NotifierThread(future);
    hilo.start();
} finally {
    client.close();
}