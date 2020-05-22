static ObjectMapper o = new ObjectMapper();
   public static void main(String[] args) throws IOException 
   {
      List<Map> array = new ArrayList<Map>();
      Map<String, String> obj1 = new LinkedHashMap<String, String>();
      obj1.put("CUSTOMER_SECTOR_ID", "Id");
      obj1.put("CUSTOMER_NO", "No");
      obj1.put("CUSTOMER_NAME", "Name");
      array.add(obj1);
      System.out.println(o.writeValueAsString(array));
   }