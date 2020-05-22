Map<String, Boolean> map = new HashMap<String, Boolean>();
//...stuff to populate the Map
Boolean value = map.get("someKey");
if(value != null && value) {
    //do stuff
}