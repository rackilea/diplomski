public static void main(String[] args) {
    try{
        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");

        List<Object> obj = new ArrayList<Object>();  


        List<String> keys = new ArrayList<String>();
        List<String> values = new ArrayList<String>();

        for(Entry<String, String> myMap : map.entrySet()){
            keys.add(myMap.getKey());
            values.add(myMap.getValue());
        }  

        DataClass dataObj = new DataClass();
        dataObj.setData(keys);
        dataObj.setStaticData("HELLO");
        obj.add(dataObj);

        CategoryClass catObj  = new CategoryClass();
        catObj.setCategories(values);
        obj.add(catObj);

        Gson gson = new Gson();  
        String jsonStr = gson.toJson(obj);
        System.out.println(jsonStr);
    }
    catch(Exception ex){
        ex.printStackTrace();
    }
}