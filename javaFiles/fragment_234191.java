try
        {
           HttpClient client = new DefaultHttpClient();
           HttpPost post = new HttpPost("http://example.com:3000/");
           JSONObject msg = new JSONObject();  Log.e("data",code);
           msg.put("data", code);

           // modified code below
           HttpEntity entity = new StringEntity(msg.toString(), ContentType.create("application/json"));
           post.setEntity(entity);

           BufferedReader reader = new BufferedReader(new   
           InputStreamReader(client.execute(post).getEntity().getContent()));
           String response = reader.readLine();
           Log.e("response", response);

        }
        catch(Exception e)
        { Log.e("",e.toString());
        }