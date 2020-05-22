public class TestHalfNumber {

private HalfNumber classUnderTest;

Map<String,Object> bindingsMap;

protected Map<String, String> captured;
@Mock
protected Resource resource;    
@Mock
protected ResourceResolver resourceResolver;
@Mock
protected SlingHttpServletRequest sServletReq;

// ---------------------------------------------------------------------------
/**
 * @param object
 *            of type WCMUsePojo. This object cannot be null.
 * @param map
 *            containing properties that needs to be initialized with
 *            WCMUsePojo
 */
// ---------------------------------------------------------------------------
public void init(WCMUsePojo obj, Map<String, Object> map) {
    Map<String, Object> staticMap = new HashMap<String, Object>();

    staticMap.put("resource", resource);

    staticMap.put("request", sServletReq);

    if (map != null)
        staticMap.putAll(map);

    if (obj != null)
        obj.init(new SimpleBindings(staticMap));
    else
        throw new IllegalArgumentException("Subclass object is null ");
}


@Before
public void setUp()
{
    MockitoAnnotations.initMocks(this); 
    classUnderTest = new HalfNumber();  
    when(sServletReq.getResourceResolver()).thenReturn(resourceResolver);   
}

// ---------------------------------------------------------------------------
/**
 * Test case for GetHalfValue 
 */
// ---------------------------------------------------------------------------
@Test
public void testGetHalfValue() throws Exception{

    int inputValue = 5;
    int expected = 3;

    bindingsMap = new HashMap<String,Object>();

    //Here is where we change the 4 by a 5 or any other value to test.
    bindingsMap.put("value",inputValue); 

    init(classUnderTest,bindingsMap);
    int result = classUnderTest.getHalfValue();
    Assert.assertEquals(expected,result);

    }

}