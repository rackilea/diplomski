JSONObject json = new JSONObject();
  JSONArray scene = new JSONArray();
    JSONObject node = new JSONObject();
    node.put("id", 0);
    node.put("calendar_event", "urlaub");
      JSONArray element = new JSONArray();
        JSONObject enode = new JSONObject();
        enode.put("anything", "");
      element.add(enode);
      //...
    node.put("element", element);
  scene.add(node);
json.put("scene", scene);
//...