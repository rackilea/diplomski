StringBuilder builder = new StringBuilder();
   for(int i=0;i<nodes.getLength();i++) {
      Element element = (Element)nodes.item(i);

      Map<String, String> obj=new LinkedHashMap<String, String>();
      obj.put("category",getElementValue(element,"category"));
      obj.put("title",getElementValue(element,"title"));
      obj.put("date",getElementValue(element,"pubDate"));
      obj.put("description",getElementValue(element,"description"));
      obj.put("content",getElementValue(element,"content:encoded"));
      StringWriter out = new StringWriter();
      JSONValue.writeJSONString(obj, out);
      String jsonText = out.toString();
      System.out.println(jsonText);
      builder.append(jsonText);
   }