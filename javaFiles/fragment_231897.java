DefaultHttpClient httpclient = new DefaultHttpClient();
HttpHost proxy = new HttpHost(proxyHost, proxyPort, "http");
httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
httpclient.getCredentialsProvider().setCredentials(
                    AuthScope.ANY,
                    new UsernamePasswordCredentials(username, password));
SolrServer solrServer = new HttpSolrServer(solrUrl, httpclient);