@RunWith(MockitoJUnitRunner.class)
public class MyTest
{
    @Mock
    private BufferedReaderFactory mockFactroy;

    @Test
    public void testIOException() throws IOException
    {
        String ivalidFileName = "invalid.txt";
        //throw exception in case that invalid file name is passed to the factory
        Mockito.when(mockFactroy.createBufferedReader(ivalidFileName)).thenThrow(new IOException("Hello!"));

        CsvFileReader csvFileReader = new CsvFileReader(mockFactroy);
        //invoke with a factory that throws exceptions
        csvFileReader.readCsvFile(ivalidFileName);
        //...
        //and make a sensible test here, e.g. check that empty list is returned, or proper message is logged, etc.
    }
}