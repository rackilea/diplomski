String dummyStr="[{\"Emp_Id\":\"1254\",\"Emp_Name\":\"abcd\"},{\"Emp_Id\":\"1234\",\"Emp_Name\":\"efgh\"}]";

    JsonParser parser = new JsonParser();
    // parse the string as JsonArray
    JsonArray tmpJsonArrayList = (JsonArray) parser.parse(dummyStr);


    System.out.println("The JSON string List is"+tmpJsonArrayList);