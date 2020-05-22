private A a;
private B b;


@Before
public void setUp() throws Exception {
  a = new A(mock.Service.class); // cause it have an argument
  b = new B(mock.Service.class); // cause it have an argument
  list.add(a);
  list.add(b);
}