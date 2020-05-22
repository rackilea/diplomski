@RunWith(MockitoJUnitRunner.class)
public class ExampleTest {
    @Mock
    private MyHelper adapter;

    @InjectMocks
    private MyService fixture;

    @Test
    public void shouldFlagFailedConversionUsingSpy()
            throws Exception {

        doThrow(new UnmarshalException("foo")).when(adapter).unmarshal(eq("Type 1"));

        Thing actual = fixture.process();
        assertEquals(1, actual.failedConversions.size());
        assertThat(actual.failedConversions.contains(Example.EntryType.TYPE_1), is(true));
    }
}