@Mock
private Map<String, Integer> map1;

@Mock
private Map<String, Date> map2;

private ClassUnderTets cut;

@Before
public void setUp() throws Exception {
    cut = new ClassUnderTets(map1, map2);
}