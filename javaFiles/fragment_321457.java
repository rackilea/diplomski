// this is your json object
  JSONObject jsonobject = new JSONObject(map);
  // get json string
  String prettyJSONString = jsonobject.toString(4);
  // mapping
  Map<String,Object> map = (Map<String, Object>) yaml.load(prettyJSONString);
  // convert to yaml string (yaml formatted string)
  String output = yaml.dump(map2);