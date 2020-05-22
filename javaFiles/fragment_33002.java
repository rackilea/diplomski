String string=request.getParameter("a");
HttpClient httpclient = new DefaultHttpClient();
HttpGet httpget = new HttpGet("http://translate.google.com/translate_tts?tl=en&q="+string);
HttpResponse res = httpclient.execute(httpget);
HttpEntity entity = res.getEntity();
if (entity != null) {
    InputStream instream = entity.getContent();
    OutputStream t = new FileOutputStream(new File("C:\\Documents and Settings\\shamik\\My Documents\\NetBeansProjects\\freetts\\web\\resources\\newfile.mp3"));
    int l;
    byte[] tmp = new byte[2048];
    while ((l = instream.read(tmp)) != -1) {
    t.write(tmp, 0, l);
    }
    instream.close();
    t.flush();
    t.close();