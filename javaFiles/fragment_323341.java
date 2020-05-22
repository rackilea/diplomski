// JMeter Engine
StandardJMeterEngine jmeter = new StandardJMeterEngine();

// Initialize Properties, logging, locale, etc.
JMeterUtils.loadJMeterProperties("c:\\path\\jmeter.properties");
JMeterUtils.setJMeterHome("C:\\path\\apache-jmeter-5.0");
JMeterUtils.initLocale();

// Initialize JMeter SaveService
SaveService.loadProperties();

// Load existing .jmx Test Plan
Path path = Paths.get("C:\\path\\whatever.jmx");
HashTree testPlanTree = SaveService.loadTree(path.toFile());

SearchByClass<Arguments> udvSearch = new SearchByClass<>(Arguments.class);
testPlanTree.traverse(udvSearch);
Collection<Arguments> udvs = udvSearch.getSearchResults();

Arguments userDefinedVariables = udvs.stream().findAny().get();

System.out.println("Current values:");

userDefinedVariables.getArgumentsAsMap().forEach((k, v) -> System.out.println("Name : " + k + " Value : " + v));

userDefinedVariables.addArgument("foo", "bar");

SaveService.saveTree(testPlanTree, new FileOutputStream("C:\\path\\whatever.jmx"));