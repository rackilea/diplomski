class SomeClass extends NPC {
// will be called during deserialization
public SomeClass(){
// call custom constructor of NPC
super(null);
}
}

class Person extends SomeClass implements Serializable {
// ..
}