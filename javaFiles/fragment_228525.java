import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class ConverterContextTest {

    ConverterContext converterContext;  

    @Mock
    FooDep fooDep;

    @Mock
    BarDep barDep;

    @BeforeEach // or @Before in JUnit 4
    void init{
        converterContext = new ConverterContext(fooDep, barDep);
    }

    @Test
    void converterContextGivesCorrectConverter(){
        // mock which is required
        /...
        assertEquals(new ConverterRegisterUserDto(), converterContext.getConverter(ConverterRegisterUserDto.class));
        // mock which is required
        /...
        assertEquals(new ConverterShowUserDto(), converterContext.getConverter(ConverterShowUserDto.class));
    }
}