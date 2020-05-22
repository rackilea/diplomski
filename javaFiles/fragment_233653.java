public class ClientTest {
    private MemoryCache memoryCache = mock(MemoryCache.class);
    private FileStatus fileStatus = mock(FileStatus.class);

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void getObjTest() throws Exception {
        Path path = new Path("xyz://aa-bb-cc/data7-1-23-a.txt");

        // create the class-under-test, supplying the mocked MemoryCache
        Foo foo = new Foo(memoryCache);

        // establish your expectations on the mocked classes
        // for this test the expectations are:
        // - memoryCache returns the mocked fileStatus    
        // - the mocked fileStatus 'is a' directory        
        when(memoryCache.getFileStatus(path.toString())).thenReturn(fileStatus);
        when(fileStatus.isDirectory()).thenReturn(true);

        // you expect a FileNotFoundExceptionException ...
        exception.expect(FileNotFoundException.class);

        // ... when you invoke getObj
        foo.getObj("aString", path);
    }
}