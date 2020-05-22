JSONParser parser = new JSONParser();

        String requestFile = System.getProperty("user.dir") + "/src/test/resources/request/original_request.json";
        logger.info("Loading request file: " + requestFile);
        Object obj = parser.parse(new FileReader(requestFile));

        Object jsonObject = (JSONObject) obj;

        //remove product_name
         ((HashMap) jsonObject).remove("product");

        logger.info("New request "+jsonObject);