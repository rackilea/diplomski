RunWith(PowerMockRunner.class)
@PrepareForTest({SystemSettings.class})
public class EngineTest extends TestCase {
    public void testLoadLanguageCodeFile() throws Exception {
        //Arrange
        String path = "Path to test file to be read";
        PowerMockito.mockStatic(SystemSettings.class);
        //instance mock
        SystemSettings settings = Mockito.mock(SystemSettings.class);
        Mockito.when(settings.getLangCodePath()).thenReturn(path);
        //mock static call
        Mockito.when(SystemSettings.GetInstance()).thenReturn(settings);
        HashMap<String, String> hash_map = new HashMap<String, String>();

        //Act
        HashMap<String, String> actual = Engine.loadLanguageCodeFile(hash_map);

        //Assert
        //perform assertion
    }
}