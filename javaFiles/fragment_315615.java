JSONObject jsonObj= new JSONObject();
jsonObj.put("word", "seven");
jsonObj.put("sequenceNumber", new Integer(34));

//save
Event eventDocument = new Event("pick",jsonObj);
mongoOperations.save(eventDocument);

//find
Query query = new Query(Criteria.where("name").is("pick"));
Event object = (Event) mongoOperations.findOne(query, Event.class);
System.out.println(object.getName());
System.out.println(object.getMessage());