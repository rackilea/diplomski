public static void main(String[] args){
    try
    {
        URL url = new URL("https://api.stackexchange.com/2.2/questions?order=desc&sort=activity&site=stackoverflow");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        System.out.println(conn.getResponseCode());



        GZIPInputStream gzis = new GZIPInputStream(conn.getInputStream());
        InputStreamReader reader = new InputStreamReader(gzis);
        BufferedReader in = new BufferedReader(reader);

        String readed;
        while ((readed = in.readLine()) != null) {
            System.out.println(readed);
        }
        //BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String output;

        while ((output = in.readLine()) != null)
        {
            System.out.println(output);
        }

    }
    catch (Exception e)
    {
        e.printStackTrace();
    }

    }