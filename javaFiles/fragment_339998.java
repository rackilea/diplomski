httpConn.setDoOutput(true);
httpConn.setRequestMethod("POST");
httpConn.setRequestProperty("X-Parse-Application-Id", "App_Id");
httpConn.setRequestProperty("X-Parse-REST-API-Key", "APp_KeY");
httpConn.setRequestProperty("Content-type", "application/json");
String json = "{\"myclass\":"
            + "{ "
            + "\"name\":\"" + name + "\","
            + "\"__type\": \"File\""
            + "}"
            + "}";
httpConn.getOutputStream().write(json.getBytes());