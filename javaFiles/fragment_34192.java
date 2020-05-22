@RunWith(PowerMockRunner.class)
@PrepareForTest({ManageUser.class})
public class ClassInTest {

    @Test
    public void testStatic() {
       ManageUser mUser = new ManageUser();
       Field field = PowerMockito.field(ManageUser.class, "gUserBO");
       field.set(ManageUser.class, mock(UserBO.class));
       ...
    }
}