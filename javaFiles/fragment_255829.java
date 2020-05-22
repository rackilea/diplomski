// Map that tells what word should be coupled to what action
Map<String, Class<? extends IAction>> actionMapping = new HashMap<>();
actionMapping.put("WRITE", Write.class);
actionMapping.put("READ", Read.class);

// Lookup the action class for the input and instantiate it
IAction action = actionMapping.get(userInput.toUpperCase()).newInstance();