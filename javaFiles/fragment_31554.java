JSONObject dataSet = new JSONObject();
dataSet.put("keyA", "SomeValueA") ;
dataSet.put("keyB", "SomeValueB") ;
dataSet.put("keyC", "SomeValueC") ;

JSONObject someProperty = new JSONObject();
dataSet.put("someproperty", "aproperty") ;

JSONArray properties = new JSONArray();
properties.add(dataSet);
properties.add(someProperty);