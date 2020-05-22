Collection unsafe = new ArrayList(); 
unsafe.add(1);                       
unsafe.add("hello");

// in the constructor, just add String values from the unsafe collection
Collection<String> example = new ArrayList<String>(); 
for(Object value:unsafe){
    if(value instanceof String){
        example.add((String)value);
    }
}