@Autowired
private A a;

@Autowired
private B b;

@Mock
private C c;

@Before
public void setup() {
    MockitoAnnotations.initMocks(this);
}

@Test
public void test()  {
    b.setC(c);
    when(c.getDatabaseSalary()).thenReturn(...);
    a.obtainSalaryA();
}