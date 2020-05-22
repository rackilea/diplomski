for (Object object : data) {

      Map row = (Map) object;
      Iterator entries = row.entrySet().iterator();
      while (entries.hasNext()) {
           Map.Entry entry = (Map.Entry) entries.next();
           System.out.println("Key = " + key + ", Value = " + entry.getValue());
     }
 }