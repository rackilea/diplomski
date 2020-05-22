private ByteBuffer ExampleForMapTypes(JSONObject data){
        Map<String, String> mapper = new HashMap<>();            
        String user = data.get("Map_Left").toString();
        String agent = data.get("Map_Right").toString();
        mapper.put(user, agent);

        return MapType
          .getInstance(UTF8Type.instance, UTF8Type.instance)
          .decompose(mapper);
    }