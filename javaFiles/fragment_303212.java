Products p = new Products();
    ObjectMapper mapper = new ObjectMapper();
    String JSON = mapper.writeValueAsString(p); // to get json string 


    mapper.readValue(JSON, Products.class); // json string to obj