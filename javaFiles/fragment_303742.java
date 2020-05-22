String arrayStr = mPrefs.getString("myObject","defValue");
Gson gson = new Gson();
List<Class> array = gson.fromGson(arrayStr,new TypeToken<List<Class>>(){}.getType());
if(array==null){
    array = new ArrayList<>();
    array.add(...);
}