@RunWith(MockitoJUnitRunner.class)
public class YourTest {
    @Mock
    private private MessageParser messageParserMock;

    // this one you need to test
    private MyXML myXML;

    @Test
    public void test() {
        myXML = new MyXML(messageParserMock);

        // I believe something like this should work
        Mockito.doAnswer(/* check mockito Answer to figure out how */)
            .when(messageParserMock).getArrtibuteUsingXPath(anyString());
        // you should do this for all your 3 getArrtibuteUsingXPath because setValueA(), setValueB(), setValueC() are called that one and then call build and verify results

        myXML.build(); // for instance
        assertEquals("something you return as Answer", myXML.getValueA());
    }
}