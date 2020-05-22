File payload = new File("/Users/CasinoRoyaleBank")
MultipartEntity entity = new MultipartEntity( HttpMultipartMode.BROWSER_COMPATIBLE );
entity.addPart( "file", new FileBody(payload))
entity.addPart( "username", new StringBody("bond"))
entity.addPart( "password", new StringBody("vesper"))
httpPost.setEntity( entity );
CloseableHttpResponse response = httpclient.execute(httpPost);