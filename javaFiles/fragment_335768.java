try
                 {

                    URL url = new URL("http:/xx.xxx.xxx.x:80/sample.jsp");
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                     InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                     BufferedReader r = new BufferedReader(new InputStreamReader(in));
                     String x = "";
                     String total = "";
                     int i=0;
                     ArrayList<String> content = new ArrayList();
                     while((x = r.readLine()) != null)
                     {
                                 content.add(x);

                     }
                     in.close();
                     r.close();
                 }
                 catch(Exception e)
                 {
                     e.printStackTrace();
                     Toast.makeText(Customer.this, e.toString(), Toast.LENGTH_SHORT).show();
                 }