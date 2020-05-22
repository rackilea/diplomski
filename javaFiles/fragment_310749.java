Gson gson = new Gson();

    String jsonString = "[{\"id\":18,\"city\":\"test\",\"street\":\"test 1\",\"zipcode\":121209,\"state\":\"IL\",\"lat\":32.158138,\"lng\":34.807838},{\"id\":19,\"city\":\"test\",\"street\":\"1\",\"zipcode\":76812,\"state\":\"IL\",\"lat\":32.161041,\"lng\":34.810410}]";

    List<Map> tmpList = gson.fromJson(jsonString);
    List<T> resultList = new Arraylist<T>(tmplist.size());
    for(Map map:tmpList){
       String tmpJson = gson.toJson(map);
       resultList.add(gson.fromJson(tmpJson, classT));
    }
    return resultList;