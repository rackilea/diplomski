while ((ReadResponses = in.readLine()) != null) {
        Constants.Response_From_server = ReadResponses;

        if (Constants.Response_From_server.startsWith("{")) {
            ListOfContactStatus = new ArrayList<ContactStatus>();
            ContactStatus contactStatusObject;

            try {
                JSONObject json = new JSONObject(Constants.Response_From_server);

                for (int i = 0; i < json.length(); i++) {
                    contactStatusObject = new ContactStatus();

                    JSONObject json1 = json.getJSONObject(String.valueOf(i));
                    System.out.println("" + json1.getString("id"));
                    System.out.println("" + json1.getBoolean("status"));
                    System.out.println("" + json1.getDouble("distance"));

                    contactStatusObject.setId(json1.getString("id"));
                    contactStatusObject.setStatus(json1.getBoolean("status"));
                    contactStatusObject.setDistance((float) json1.getDouble("distance"));
                    ListOfContactStatus.add(contactStatusObject);
                    System.out.println("HTTPTransport:sendMessage  Size of ListOfContactStatus" + ListOfContactStatus.size());
                }
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}