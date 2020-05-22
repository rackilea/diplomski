HashMap<String, Vector<String>> var = new HashMap<String, Vector<String>>();

String key= "key";
String value = "value";

if(var.containsKey(key)){
// the set is already there we can proceed to add the value
} else {
    //first time you have to create the List
    var.put(key, new Vector<String>());
}
var.get(key).addElement(value);