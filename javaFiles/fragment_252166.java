@InjectMocks
@Spy
MyDictionary dictionary;

@Test
public void testMyDictionary(){
    doReturn("value").when(dictionary).get("key);
    Assert.assertEquals("value", dictionary.get("key"));
}