@RunWith(PowerMockRunner.class)
@PrepareForTest(DriverManager.class)
public class Mocker {

    @Test
    public void shouldVerifyParameters() throws Exception {

        //given
        PowerMockito.mockStatic(DriverManager.class);
        BDDMockito.given(DriverManager.getConnection(...)).willReturn(...);

        //when
        sut.execute(); // System Under Test (sut)

        //then
        PowerMockito.verifyStatic();
        DriverManager.getConnection(...);

    }