String Xpath = "map/map";
//For every occurence of list/map add map object to list object
    digester.addObjectCreate("list/map", ArrayList.class);

    digester.addObjectCreate(Xpath, HashMap.class);
    digester.addCallMethod(Xpath+"/val" , "put", 2);
    digester.addCallParam(Xpath+"/val", 0, "name");        
    digester.addCallParam(Xpath+"/val", 1);

digester.addSetNext("list/map", "add"); 


It works fine.