public static void httptest() {
            ArrayList<TravellingData> tdArray = new ArrayList<TravellingData>();
            Gson gson = new Gson();
            String jsonString = "";
            for (int i = 0; i < 1; i++) {
                tdArray.add(ObjectCreater.createMockTravellingDataObject());
            }

            jsonString = gson.toJson(tdArray);

            HttpClient client = new DefaultHttpClient();

            HttpPost post = null;
            try {
                post = new HttpPost(
                        "http://localhost:8080/uygulama/clientdatacollector");
            } catch (URISyntaxException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            try {
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
                nameValuePairs.add(new BasicNameValuePair("gpsdata", jsonString));
                post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                HttpResponse response = null;
                try {
                    response = client.execute(post);
                } catch (HttpException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                BufferedReader rd = new BufferedReader(new InputStreamReader(
                        response.getEntity().getContent()));
                String line = "";
                while ((line = rd.readLine()) != null) {
                    System.out.println(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }