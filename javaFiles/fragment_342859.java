List<Bson> arrFilters = new ArrayList<>();
arrFilters.add(new Document("elem.apn", "abcdef")); // this specifies the element search criteria
FindOneAndUpdateOptions updateOptions = new FindOneAndUpdateOptions().arrayFilters(arrFilters);

String [] dArray = { "app", "ban", "ora" }; // the "d" array to be added
Bson update = set("session.ps.$[elem].d", Arrays.asList(dArray));

String idStr = "5e37dc262f5ff4dfc935eb6b";
Bson queryFilter = eq("_id", new ObjectId(idStr));

Document result = coll.findOneAndUpdate(queryFilter, update, updateOptions);
System.out.println(result);