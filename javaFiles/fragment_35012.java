//first, you create a mapper object
    ObjectMapper mapper = new ObjectMapper();

    //then you create a JsonNode instance representing your JSON root structure
    JsonNode root = null;
    try {
        root = mapper.readTree(json);
    } catch (IOException e) {
        e.printStackTrace();
    }

    //here you get the list of your patches nodes
    JsonNode list = root.path("patches");

    //then you can iterate through them and get any inner value
    for (JsonNode patch : list) {
        //for example, you can get a file name
        System.out.println(patch.path("name"));
    }