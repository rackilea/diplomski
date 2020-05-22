@PrepareForTest({ LocalDate.class })
@RunWith(PowerMockRunner.class)
public class DateTest {
    @Test
    public void yourTest() {
        PowerMockito.mockStatic(LocalDate.class);
        when(LocalDate.now()).thenReturn(yourLocalDateObj);
    }
}