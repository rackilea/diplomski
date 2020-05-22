//Convert to JSON
System.out.println(gson.toJson(employee));

//Convert to java objects
System.out.println(gson.fromJson("{'id':1,'firstName':'Lokesh','lastName':'Gupta','roles':['ADMIN','MANAGER'],'birthDate':'17/06/2014'}"
                            , Employee.class));