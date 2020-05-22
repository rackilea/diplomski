@RunWith(PowerMockRunner.class)
public class BufferedBZIP2FilterFactoryTest {

    @Test
    @PrepareForTest({BufferedBZIP2FilterFactory.class})
    public void wraps_InputStream_in_BufferedInputStream() throws Exception {
        whenNew(CBZip2InputStream.class).withArguments(isA(BufferedInputStream.class))
                .thenReturn(Mockito.mock(CBZip2InputStream.class));

        new BufferedBZIP2FilterFactory().makeFilter(anInputStream());

        verifyNew(CBZip2InputStream.class).withArguments(isA(BufferedInputStream.class));
    }

    private ByteArrayInputStream anInputStream() {
        return new ByteArrayInputStream(new byte[10]);
    }
}