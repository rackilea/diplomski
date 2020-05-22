import com.google.gson.Gson;
    import com.google.gson.JsonArray;
    import com.google.gson.JsonElement;
    import com.google.gson.JsonObject;
    import com.google.gson.JsonParser;

    public static void parseJson (){

     String thisJson ="{\r\n" + 
            "  \"metadata\": {\r\n" + 
            "    \"offset\": 0,\r\n" + 
            "    \"psize\": 10\r\n" + 
            "  },\r\n" + 
            "  \"svc\": [\r\n" + 
            "    {\r\n" + 
            "      \"mNumber\": \"225\",\r\n" + 
            "      \"markIp\": {\r\n" + 
            "        \"Name\": \"Ant\",\r\n" + 
            "        \"eDate\": \"3006-08-01\",\r\n" + 
            "        \"cDate\": \"9999-12-31\"\r\n" + 
            "      },\r\n" + 
            "      \"mkDetails\": [\r\n" + 
            "        {\r\n" + 
            "          \"Alpha\": \"D\",\r\n" + 
            "          \"Beta\": \"S\"\r\n" + 
            "        }\r\n" + 
            "      ],\r\n" + 
            "      \"mNetDetails\": [\r\n" + 
            "        {\r\n" + 
            "          \"Gaama\": \"213\",\r\n" + 
            "          \"mkTypeCode\": \"23\"\r\n" + 
            "        }\r\n" + 
            "      ]\r\n" + 
            "    }\r\n" + 
            "  ],\r\n" + 
            "  \"serviceFault\": {\r\n" + 
            "    \"faultType\": null,\r\n" + 
            "    \"faultCode\": null,\r\n" + 
            "    \"message\": null\r\n" + 
            "  }\r\n" + 
            "}";
     Gson gson = new Gson();

     JsonElement jelement = new JsonParser().parse(thisJson);
     JsonObject  jobject = jelement.getAsJsonObject();
     JsonArray jarray = jobject.getAsJsonArray("svc");
     jobject = jarray.get(0).getAsJsonObject();

     JsonArray netDetailsArr = jobject.getAsJsonArray("mNetDetails");
     JsonArray mkDetailsArr =  jobject.getAsJsonArray("mkDetails");

     jobject = netDetailsArr.get(0).getAsJsonObject();
     String gamma = jobject.get("Gaama").getAsString();
     System.out.println("gamma==>" + gamma);

     jobject = mkDetailsArr.get(0).getAsJsonObject();
     String alpha = jobject.get("Alpha").getAsString();
     String beta = jobject.get("Beta").getAsString();

     System.out.println("alpha ==>" + alpha);
     System.out.println("beta ===>"+ beta);

 }