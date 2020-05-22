public void parseLink(String jsonObject) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonFactory factory = mapper.getJsonFactory(); // since 2.1 use mapper.getFactory() instead
            JsonParser jp = factory.createJsonParser(jsonObject);
            JsonNode input = mapper.readTree(jp);

         //   final JsonNode results = input.get("HotelListResponse").get("HotelList").get("HotelSummary");

            Iterator<Entry<String, JsonNode>> nodeIterator = input.get("HotelListResponse").getFields();

            while (nodeIterator.hasNext()) {
                Map.Entry<String, JsonNode> entry = (Map.Entry<String, JsonNode>) nodeIterator.next();
                System.out.println("key --> " + entry.getKey() + " value-->" + entry.getValue());

            }

           Iterator<Entry<String, JsonNode>> nodeIterator1 = input.get("HotelListResponse").get("HotelList").getFields();

            while (nodeIterator1.hasNext()) {
                Map.Entry<String, JsonNode> entry = (Map.Entry<String, JsonNode>) nodeIterator1.next();
                System.out.println("key --> " + entry.getKey() + " value-->" + entry.getValue());

            }

            Iterator<Entry<String, JsonNode>> nodeIterator2 = input.get("HotelListResponse").get("HotelList").get("HotelSummary").getFields();

            while (nodeIterator2.hasNext()) {
                Map.Entry<String, JsonNode> entry = (Map.Entry<String, JsonNode>) nodeIterator2.next();
                System.out.println("key --> " + entry.getKey() + " value-->" + entry.getValue());

            }




        } catch (IOException ex) {
            Logger.getLogger(HotelBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }