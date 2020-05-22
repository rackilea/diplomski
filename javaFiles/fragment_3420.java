URL url = new URL("http://hostname:port/solr/resource/solrksname.tablename/schema.xml");

        // write
        try {

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(builder.toString());
            wr.flush();
            wr.close();

            System.out.println("Schema insert response code : " + conn.getResponseCode());

        } catch (IOException e) {
            e.printStackTrace();
        }