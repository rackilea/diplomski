public void curlParse(String token, String id)
    {

        try
        {
            Date exp = new Date();
            exp.setTime(exp.getTime() + 7200000);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"); /*2012-02-28T23:49:36.353Z */

            String sExp = sdf.format(exp);
            String resp = Request.Post("https://api.parse.com/1/users")
                    .addHeader("X-Parse-Application-Id", CWSApplication.getParseDotComApplicationID())
                    .addHeader("X-Parse-REST-API-Key", CWSApplication.getParseDotComApplicationKey())
                    .addHeader("Content-Type", "application/json")
                    .bodyString(
                            "{"
                            + " \"authData\": { "
                            + "  \"facebook\": {"
                            + " \"id\": \"" + id + "\","
                            + "\"access_token\": \"" + token + "\","
                            + " \"expiration_date\": \"" + sExp + "\""
                            + " }"
                            + "}"
                            + "}", ContentType.APPLICATION_JSON
                    )
                    .execute().returnContent().asString();

            /*System.out.println(ResponseParse);*/
            CWSSession session = (CWSSession) getSession();
            ParseUser loggedUser = new ParseUser();
/*questo con la libreriagson ci legge il JSON che ha i dati che ci servono da mettere su Parse*/
            try
            {
                JsonReader reader = new JsonReader(new StringReader(resp));

                reader.beginObject();

                while (reader.hasNext())
                {

                    String name = reader.nextName();

                    if (name.equals("objectId"))
                    {
                        loggedUser.setObjectId(reader.nextString());

                    } else if (name.equals("sessionToken"))
                    {
                        loggedUser.setSessionToken(reader.nextString());

                    } else
                    {
                        reader.skipValue(); //avoid some unhandle events
                    }
                }

                reader.endObject();
                reader.close();

            } catch (IOException e)
            {
                e.printStackTrace();
            }
}