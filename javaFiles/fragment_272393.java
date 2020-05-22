final Person p3 = Person.of(new PersonInfo(
    public String  name   () { return p.name(); )
    public Address address() { return Address.of(new AddressInfo() {
       private final Address a = p.address();
       public String house  () { return a.house()  ; }
       public String street () { return a.street() ; }
       public String city   () { return "Berlin"   ; }
       public String country() { return a.country(); }
    })),
    public Xxx     x() { return p.x(); }
    public Yyy     y() { return p.y(); }
    public Zzz     z() { return p.z(); }
 });