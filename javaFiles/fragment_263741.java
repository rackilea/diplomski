@RunWith(MockitoJUnitRunner.class)
public class ClassToTestTest {

    ...
    @Captor ArgumentCaptor<List<Z>> listCaptor

    @Test public void ensure_that_list_with_value___Z___is_passed_to___AnotherClass() {
        // given

        // when
        ...

        // then
        verify(anotherClass).receiveList(listCaptor.capture());
        assertThat(listCaptor.getValue()).contains(Z);
    }
}