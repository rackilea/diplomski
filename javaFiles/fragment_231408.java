String jsonStr =  "{\"8\":{\"Name\":\"test1\",\"city\":\"ny1\"},"
                + " \"9\":{\"Name\":\"test2\",\"city\":\"ny2\"}}";

JSONObject parent = new JSONObject(jsonStr);

for (Object key : parent.keySet()){
    JSONObject childObject = parent.getJSONObject(key.toString());

    System.out.println("-----------");
    System.out.println(childObject);
    System.out.println("Name = "+childObject.get("Name"));
    System.out.println("city = "+childObject.get("city"));
}