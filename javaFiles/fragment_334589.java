while(cursor.hasNext()) {
   Document documentEmployee = cursor.next();
   System.out.println(documentEmployee.getString("name"));
   System.out.println(documentEmployee.getInteger("age"));
   System.out.println(documentEmployee.getInteger("phoneNr"));
   //Extract
   ArrayList projects = documentEmployee.get("project", ArrayList.class);
   //Map
   for (Object obj : projects) {
         Document project = (Document) obj;
         project.getString("projectName");
   }
}