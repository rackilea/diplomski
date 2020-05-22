// using map to get all the keys & their values.
public Map login(@RequestParam Map<String, String> map){

}

// get all the form parameter in separate method parameter like so
// (key name are dummies here, use appropriate names when using)
public Map login(@RequestParam("key1") String key1, @RequestParam("key2") String key2){

}