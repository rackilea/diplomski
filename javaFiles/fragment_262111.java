String substring = data.substring(12);
//check if name is unique

// add this line
String uniqueKey = findUniqueKey(hm, substring);

//add to map with the calculated value
hm.put(uniqueKey, object);----- HERE IS THE PROBLEM