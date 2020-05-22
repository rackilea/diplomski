// collect into a map
Map<String, Object> map = /* hash map, linked hash map, tree map, you decide */;
consumeFile(yamlFile, map::put);

// just print them, why not?
consumeFile(yamlFile, (key, value) -> System.out.println(key + " = " + value));