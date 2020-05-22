URL url = new URL("http://myurl/");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");

            String input = "{\"foo\":\"bar\"}";
            OutputStream ous = con.getOutputStream();
            ous.write(input.getBytes());
            ous.flush();

            if (con.getResponseCode() != HttpURLConnection.HTTP_OK)
            {
                throw new RuntimeException("Failed : HTTP error code : " + con.getResponseCode());
            }else
            {
                BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
                String output;
                System.out.println("Output from Server .... \n");
                while ((output = br.readLine()) != null) 
                {
                     System.out.println(output);
                }
            }

            con.disconnect();