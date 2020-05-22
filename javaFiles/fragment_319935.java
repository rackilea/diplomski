KeyStore trustStore  = KeyStore.getInstance( "BKS" /*KeyStore.getDefaultType()*/ );
FileInputStream instream = new FileInputStream(new File("/mnt/sdcard/keystore.bks"));
try {
    trustStore.load(instream, "222222".toCharArray());
} catch (NoSuchAlgorithmException e) {
    e.printStackTrace();
} catch (CertificateException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
} finally {
    try { instream.close(); } catch (Exception ignore) {}
}

// Create socket factory with given keystore.
SSLSocketFactory socketFactory = new SSLSocketFactory(trustStore);

SSLSocketFactory socketFactory = new SSLSocketFactory(trustStore);
Scheme sch = new Scheme("https", socketFactory, 443);
httpclient.getConnectionManager().getSchemeRegistry().register(sch);

HttpGet httpget = new HttpGet("https://10.2.20.20/fido/EzPay/login.php");

System.out.println("executing request " + httpget.getRequestLine());

HttpResponse response = httpclient.execute(httpget);
HttpEntity entity = response.getEntity();

System.out.println("----------------------------------------");
System.out.println(response.getStatusLine());
if (entity != null) {
    System.out.println("Response content length:  " + entity.getContentLength());
}

// Print html.
BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
String line = "";
while ((line = in.readLine()) != null) {
     System.out.println(line);
}
in.close();