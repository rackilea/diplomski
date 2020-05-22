String ar = "[{\"id\":1,\"session_id\":\"11611fba0cd57f2f0e62acf746d7f60b\",\"link\":\"\",\"created_at\":\"2013- 12-10T13:13:31.000Z\",\"updated_at\":\"2013-12-10T13:13:31.000Z\"}, \n"
                + "{\"id\":2,\"session_id\":\"848960680b00502fc3e4c9cf0652a5fe\",\"link\":\"\",\"created_at\":\"2013-12-10T13:13:31.000Z\",\"updated_at\":\"2013-12-10T13:13:31.000Z\"},\n"
                + "{\"id\":3,\"session_id\":\"101155b2c4cef0034804ed9b6806422e\",\"link\":\"\",\"created_at\":\"2013-12-10T13:13:31.000Z\",\"updated_at\":\"2013-12-10T13:13:31.000Z\"},\n"
                + "{\"id\":4,\"session_id\":\"ec1373a7bdd291f60266ab6f8445c23b\",\"link\":\"\",\"created_at\":\"2013-12-10T13:13:31.000Z\",\"updated_at\":\"2013-12-10T13:13:31.000Z\"},\n"
                + "{\"id\":5,\"session_id\":\"3eb8b185f0cbd71ff004b30453c90f54\",\"link\":\"\",\"created_at\":\"2013-12-10T13:13:31.000Z\",\"updated_at\":\"2013-12-10T13:13:31.000Z\"}]";

        String token_id = "3eb8b185f0cbd71ff004b30453c90f54";
        JSONArray jsonArray = new JSONArray(ar);
        boolean match_found = false;
        o:
        for (int i = 0; i < jsonArray.length(); i++) {
            if (token_id.equals(jsonArray.getJSONObject(i).getString("session_id"))) {
                match_found = true;
                break o;
            }
        }
        if(match_found  == true)
        {
            response.sendRedirect("error.jsp");
        }