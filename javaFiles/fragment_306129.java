Document documents = new Document();
        documents.put("dummyVal", "MId from step 4"); 
        documents.put("timekey", "timestamp"); 
        documents.put("macKey", "dummyVal"); 
        List<String> litItem = new ArrayList<String>();
        litItem.add("setting1");
        litItem.add("setting2");
        documents.put("keys", litItem); // picked keys from page 4
        documents.put("macKey", "dummyVal"); 
        Document documents1 = new Document();
        documents1.put("dummyVal", "MId from step 4"); 
        documents1.put("timekey", "timestamp");
        documents1.put("macKey", "dummyVal"); 
        List<String> litItem1 = new ArrayList<String>();
        litItem1.add("setting1");
        litItem1.add("setting2");
        documents1.put("keys", litItem); // picked keys from page 4
        documents1.put("macKey", "dummyVal"); 
        docList.add(documents1);
dbCollection.insertMany(docList);