TypeToken<Map<Long,List<Person>>> token = new TypeToken<Map<Long,List<Person>>>(){};
    Map<Long,List<Person>> map_new=new HashMap<Long,List<Person>>();
    map_new=gson.fromJson(mapJsonStr,token.getType());

    //origian map
// map_new is my Map get from map's Json String