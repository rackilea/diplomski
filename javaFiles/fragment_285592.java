for (int i = 0; i < array.length(); i++) {
    JSONObject objects = array.getJSONObject(i);
    JSONArray elements = objects.getJSONArray("elements");
    for (int j = 0; j < elements.length(); j++) {
        JSONObject element = elements.getJSONObject(i);
        list.add(element.getJSONObject("distance").getString("text"));
    }
}
System.out.println(list);