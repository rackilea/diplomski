// Make a Map that tells what word should be coupled to what action
Map<String, Supplier<IAction>> actionMapping = new HashMap<>();
actionMapping.put("WRITE", Write::new);
actionMapping.put("READ", Read::new);

// When you get user input, simply lookup the supplier
// in the map and call get() on it
IAction action = actionMapping.get(userInput.toUpperCase()).get();