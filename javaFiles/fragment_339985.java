//After creating the file configuration
//Load file (in try block)
List<String> stringList = mapconfig.getStringList("Mobs");
stringList.add("mob4");
mapconfig.set("Mobs", stringList);
//Save config to file (in try block)