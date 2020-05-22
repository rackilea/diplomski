DSMBuilder builder = new DSMBuilder(new File("path/to/mapping.yaml")).setType(DSMBuilder.TYPE.XML);

 // register function
 builder.registerFunction("processFunction",processFunction);

 DSM dsm= builder.create();
 Object object =  dsm.toObject(xmlContent);
 // type of object varibale is a Map<String,Obejct>