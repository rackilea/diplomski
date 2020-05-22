BasicDBObject doc = new BasicDBObject();
//doc.put("key " , r.getKey());
doc.put("category" , r.getKey());
doc.put("type" , r.getValue());

java.util.Map<String,Float> latLongMap = new java.util.HashMap<String,Float>();
latLongMap.put("lat" , Float.parseFloat(r.getLatitude());
latLongMap.put("lon" , Float.parseFloat(r.getLongitude());

doc.put( "location" , latLongMap);