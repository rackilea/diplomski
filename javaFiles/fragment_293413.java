HttpClient httpclient = new 
        HttpResponse response = httpclient.execute(new HttpGet(url));

        if(response.getEntity().isStreaming() ){
                HttpEntity _entity = response.getEntity();
                BufferedReader reader = new BufferedReader(new InputStreamReader(_entity.getContent(),"utf-8"),8);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    System.out.println( line.toString());
                }
                _entity.getContent().close();                   
        }