List list = new ArrayList();

for (int i = 0; i <= 10; i++) {
    JSONObject nextObject = new JSONObject();
    nextObject.put("name", "Name" + i);
    list.add(nextObject);
}

JSONObject json = new JSONObject();
json.put("label", "name");
json.put("items", list.toArray());

response.getWriter().write(json.toString());