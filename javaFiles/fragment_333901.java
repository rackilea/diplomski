@Before
   public void setUp() throws Exception {
      MockitoAnnotations.initMocks(this);
      Set<Thing> things = new HashSet<Thing>();
      things.add(thing);
      widget.setThings(things); 
   }