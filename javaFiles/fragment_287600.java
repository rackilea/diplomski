//Proxy instance, proxy ip = 192.168.0.1 with port 8080  

Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("192.168.0.1", 8080));
URL url = new URL("http://www.sheldonbrown.com/web_sample1.html");
HttpURLConnection uc = (HttpURLConnection)url.openConnection(proxy);
uc.connect ();

OutputStreamWriter wr = new OutputStreamWriter(uc
              .getOutputStream());  

BufferedReader rd = new BufferedReader(new InputStreamReader(uc
                .getInputStream()));