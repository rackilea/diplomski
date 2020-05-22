String jsonXmlStr = 
        "{"+
            "\"st\": \"NSW\","+
            "\"notify_by\": \"email\","+
            "\"notify_when\": \"any\","+
            "\"pc\": 2150,"+
            "\"lo\": \"PARRAMATTA\","+
            "\"pt\": \"U\","+
            "\"childNodes\": ["+
              "{"+
                "\"val\": 50,"+
                "\"code\": \"DSR_PLUS\","+
                "\"change\": \"falls below\","+
                "\"tagName\": \"stat\""+
              "},"+
              "{"+
                "\"val\": 450000,"+
                "\"code\": \"TV\","+
                "\"change\": \"rises above\","+
                "\"tagName\": \"stat\""+
              "}"+
            "],"+
            "\"tagName\": \"mkt\""+
          "}";

    JSONObject jsonXmlObject = new JSONObject(jsonXmlStr);
    System.out.println(JSONML.toString(jsonXmlObject));