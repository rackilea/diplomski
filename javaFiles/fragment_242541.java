class Things {
    public final Thing1 thing1;
    public final Thing2 thing2;
    public Things(Thing1 thing1, Thing2 thing2) {
      this.thing1 = thing1; 
      this.thing2 = thing2;
    }
    @Override
    public boolean equals(Object obj) { ... }
    @Override
    public int hashCode() { ... };
 }