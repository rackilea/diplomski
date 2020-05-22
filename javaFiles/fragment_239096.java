String addr = "http://172.26.41.18:8080/domain/list";
URL url = new URL(addr);
HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
httpCon.setUseCaches(false);
httpCon.setAllowUserInteraction(false);
httpCon.addRequestProperty("Authorization", "Basic YWRtaW4fYFgjkl5463");
System.out.println(httpCon.getResponseCode());
System.out.println(httpCon.getResponseMessage());