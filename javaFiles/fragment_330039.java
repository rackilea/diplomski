public void create(int method, final String url, final String data) {
    this.method = method;
    this.url = url;     
    this.data = data;
    if(method == GET){
        this.config = RequestConfig.custom()
            .setConnectTimeout(6 * 1000)
            .setConnectionRequestTimeout(30 * 1000)
            .setSocketTimeout(30 * 1000)                
            .build();
    } else{
        this.config = RequestConfig.custom()
                .setConnectTimeout(6 * 1000)
                .setConnectionRequestTimeout(30 * 1000)
                .setSocketTimeout(60 * 1000)                
                .build();           
    }
    this.context = HttpClientContext.create();