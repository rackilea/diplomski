// Could do something better with response.
        StatusLine statusLine = response.getStatusLine();

        if (statusLine.getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();
            InputStream content = entity.getContent();
        StringBuilder   builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(content));
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
                content.close();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
            JSONObject  jsonObject = new JSONObject(builder.toString());
            } catch (JSONException e) {
                System.out.println("Error parsing data " + e.toString());
            }

        }
    } catch (Exception e) {
        System.out.println("Error:  " + e.toString());
        System.out.println( "" + e.toString());
        System.out.println("" + e.toString());
    }