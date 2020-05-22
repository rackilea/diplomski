Map<Long,List<Person>> map=new HashMap<Long,List<Person>>();
    //adding some data

Gson gson=new Gson();
String mapJsonStr=gson.toJson(map);

//mapJsonStr : is my map's JSon Strin