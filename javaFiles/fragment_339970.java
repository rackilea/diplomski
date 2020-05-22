// I took a set because I wanted have the inputs sorted
HashMap<String, Set<String>> var = new HashMap<String, Set<String>>();

String key= "key";
String value = "value";

if(var.containsKey(key)){
// the set is already there we can proceed to add the value
} else {
    //first time you have to create the List
    var.put(key, new TreeSet<String>());
}
var.get(key).add(value);