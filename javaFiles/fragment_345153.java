Session studentDbSession = new Session("localhost",5984);

           Database studentCouchDb = studentDbSession.getDatabase("student");

           Document newdoc = new Document();

           HashMap<String , String> properties = new HashMap<String,String>();  

           newdoc.setId("c0b3457b1d6e5f8431d62a31fd00073c");

           newdoc.put("Name", "Priya");

           properties.put("10th", "69.9");

           properties.put("12th", "62.83");

           properties.put("Graduation", "69.73");

           properties.put("Post_Graduation", "71.55");

           newdoc.put("Education", properties);

           studentCouchDb.saveDocument(newdoc);