List<Map> processNeedImages = new ArrayList<>(); 
int flag =0;
if(c.moveToFirst()){
    do{
         Map<String, String> map = new HashMap<>();
         map.put("status", c.getString(c.getColumnIndex("system_url")));
         processNeedImages.add(flag++, map);
      }while(c.moveToNext());
}