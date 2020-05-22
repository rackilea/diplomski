private static HttpParams params;
params = new BasicHttpParams();
HttpClientParams.setRedirecting(params, false);
HttpClientParams.setCookiePolicy(params, CookiePolicy.BROWSER_COMPATIBILITY);
HttpClient httpclient = new DefaultHttpClient(params);

HttpPost httppost = new HttpPost("http://login.vk.com/");

            try {
                List<NameValuePair> postData = new ArrayList<NameValuePair>(); 
                postData.add(new BasicNameValuePair("act", "login"));
                postData.add(new BasicNameValuePair("success_url", ""));
                postData.add(new BasicNameValuePair("fail_url", ""));
                postData.add(new BasicNameValuePair("try_to_login", "1"));
                postData.add(new BasicNameValuePair("to", ""));
                postData.add(new BasicNameValuePair("vk", ""));
                postData.add(new BasicNameValuePair("al_test", ""));
                postData.add(new BasicNameValuePair("email", URLEncoder.encode(username, "UTF-8")));
                postData.add(new BasicNameValuePair("pass", URLEncoder.encode(password, "UTF-8")));
                postData.add(new BasicNameValuePair("expire", ""));
                httppost.setEntity(new UrlEncodedFormEntity(postData));

                HttpResponse response = httpclient.execute(httppost);
                List<Cookie> cookies = ((DefaultHttpClient)httpclient).getCookieStore().getCookies();
                for(Cookie cookie : cookies){
                Log.i("Cookie", cookie.toString());
             }

            } catch(Exception e) {

            }