try {

            Client client = Client.create();

            WebResource webResource = client.resource(http://ipadress:port/notification/signUp);

            JSONObject formData=new JSONObject();
            formData.put("name", UserName);
            formData.put("email", EmailId);
            formData.put("password", Password);
            formData.put("urlHash",HashKey);

            ClientResponse response = webResource.header("App_Key",xxxxxxxxxxxxxxxxxxxxxxxxxx).type(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class, formData);

        } catch (Exception e) {

            e.printStackTrace();
        }