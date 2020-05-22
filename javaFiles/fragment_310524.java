case "HTTP": {
    HttpProxyHost httpProxy = new HttpProxyHost();
    processRow(row, httpProxy, httpProxies);
    proxy = httpProxy;
    break;
}