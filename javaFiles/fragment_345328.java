List<String> paramNames = new ArrayList<String>{"NUMBER_OF_THREADS", "NUMBER_OF_TASKS", 
            "ID_START_RANGE", "TABLES"}; // Try to reuse the names from the property file
Map<String, String> paramMap = new HashMap<String, String>();
...
// Validate the length of args here
...
// As you table names can be passed separately. You need to handle that somehow. 
// This implementation would work when number of args will be equal to number of param names
for(int i = 0; i< args.length; i++) {
   paramMap.put(paramNames[i], args[i]); 
}

props.putAll(paramMap);
... // Here props should have it's values overridden with the ones provided