import static org.mockito.ArgumentMatchers.any;
...

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    @Test
    public void test() throws Exception {

        RestTemplate api = Mockito.mock(RestTemplate.class);

        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        Mockito.when(api.getForObject(any(String.class),any(Class.class), ArgumentMatchers.<Object>any())).thenReturn(obj1);
        Mockito.when(api.getForObject(any(String.class),any(Class.class), any(Map.class))).thenReturn(obj2);
        Mockito.when(api.getForObject(any(URI.class),any(Class.class))).thenReturn(obj3);

        Assert.assertEquals(obj1, api.getForObject("", String.class));
        Assert.assertEquals(obj1, api.getForObject("", String.class, obj1));
        Assert.assertEquals(obj1, api.getForObject("", String.class, obj1, obj2));
        Assert.assertEquals(obj1, api.getForObject("", String.class, obj1, obj2, obj3));
        Assert.assertEquals(obj1, api.getForObject("", String.class, new Object[] {obj1,obj2,obj3}));

        Assert.assertEquals(obj2, api.getForObject("", String.class, new HashMap()));

        Assert.assertEquals(obj3, api.getForObject(new URI(""), String.class));
    }
}