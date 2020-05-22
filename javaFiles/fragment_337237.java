@SubscribeMapping("/getviewschema/{tablename}")
 public JSONObject getViewSchema(@DestinationVariable String tablename) throws Exception
 {
     DataManager manager = new DataManager();
     return manager.getViewJSONSchema(tablename);
 }