@RunWith(PowerMockRunner.class)
@PrepareForTest({ResponseMapper.class})
public class ATest {

    @Test
    public void testMockingStatic() {
        PowerMockito.mockStatic(ResponseMapper.class);

        // if you want to use specific argument matchers
        Mockito.when(ResponseMapper.mapCreditInfo(
            uciPin, creditAssessmentResults)
        ).thenReturn(creditInfo);

        // or if you want to match on any arguments passed into your static method ...
        Mockito.when(ResponseMapper.mapCreditInfo(
            ArgumentMatchers.anyString(), 
            ArgumentMatchers.anyList())
        ).thenReturn(creditInfo);

        // ...
    }
}