private final List<Object[]> people = new ArrayList<>()
public void setup(){
   people.add(30, new Person(30, "Jeff"))
   people.add(50, new Person(50, "Bill"))
}

public void testGetAge(){
    setup();
    for(Object[] entry : people){
        self::assertEquals(entry[0], entry[1].getAge());
    }
}