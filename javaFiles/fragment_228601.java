Gson g = new Gson();
      JsonParser jp = new JsonParser();
      JsonElement o = jp.parse(s);
      if (o.isJsonArray()){
         List<Integer> list = (List) g.fromJson(o, listType1);
         System.out.print(list);
      }
      else{
         ServerException e = g.fromJson(s, ServerException.class);
         System.out.print(e);
      }