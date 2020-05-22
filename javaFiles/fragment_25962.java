class Thing {
  int myThing;

  public Thing(int myThing) {
    this.myThing = myThing;
  }

  public int hashCode(){
    return myThing;
  }

  public boolean equals(Object obj) {    
    Thing other = (Thing) obj;    
    return (myThing == other.myThing);
  }
}

void setup() {

  HashMap<Thing, String> map = new HashMap<Thing, String>();
  map.put(new Thing(1), "A");
  map.put(new Thing(2.5), "B"); //uh oh!
  map.put(new Thing(3), "C");
  println("1, " + map.size());                      // outputs 3         
  println("2, " + map.keySet().size());             // outputs 3
  println("3, " + map.keySet().toArray().length);   // outputs 2
}