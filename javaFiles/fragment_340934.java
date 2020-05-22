List<String> list = new ArrayList<String>();
list.add("Test1"); list.add("Test2"); list.add("Test3");
logger.debug("names: {}", list);

//produces
//xx::xx.xxx [main] DEBUG [classname] - names: [Test1, Test2, Test3]