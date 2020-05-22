// Send the HTTP POST request.
                try {
                    HttpParams params = new BasicHttpParams();
                    params.setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);


                    HttpParams httpParameters = new BasicHttpParams();
                        // Set the timeout in milliseconds until a connection is established.
                        // The default value is zero, that means the timeout is not used. 
                    int timeoutConnection = 40000;
                    HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
                        // Set the default socket timeout (SO_TIMEOUT) 
                        // in milliseconds which is the timeout for waiting for data.
                    int timeoutSocket = 60000;
                    HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
                    HttpConnectionParams.setTcpNoDelay(params, true);

                    httpParameters.setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);


                    HttpClient httpclient = new DefaultHttpClient(httpParameters);


                    HttpPost httppost = new HttpPost(base_url+"/service/list/app/");
                    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                    HttpResponse response = httpclient.execute(httppost);
                    HttpEntity entity = response.getEntity();
                    is = entity.getContent();
                } catch (Exception ex) {

                    Toast.makeText(getActivity(), "Your connection timedout", 10000).show();
                }