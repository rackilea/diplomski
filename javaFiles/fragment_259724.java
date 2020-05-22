//This will remove all Lookups for given string
gazetteer.remove("string to be found");

//This will remove a specific Lookup only
//The method is not included in the Gazetteer interface
((DefaultGazetteer) gazetter).removeLookup("string to be found", l);