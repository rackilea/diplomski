HashMap<String, Clicker> clickers = new HashMap<String, Clicker>();

// put some content to the map
clickers.put("nameForMyVariable1", new Clicker());
clickers.put("nameForMyVariable2", new Clicker());

// now you can find appropriate Clicker simply by specifying its key
clickers.get("nameForMyVariable1"); // returns Clicker with nameForMyVariable1 name