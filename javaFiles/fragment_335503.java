vNo1 = request.getParameter("no1_form");
     vName1 = request.getParameter("name1_form");


     vNo = request.getParameter("no_form");
     vName = request.getParameter("name_form");


    ObjectMapper mapper = new ObjectMapper();
    ObjectNode root = mapper.createObjectNode();
    ArrayNode names = mapper.createArrayNode();

       ObjectNode item1 = mapper.createObjectNode();
       item1.put("no", vNo1);
       item1.put("name", vName1); 
       names.add(item1);

       ObjectNode item2 = mapper.createObjectNode();
       item2.put("no", vNo);
       item2.put("name", vName); 
       names.add(item2);

    root.put("names", names);

   return root;