@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {
   @Spy
   @InjectMocks
   private AccountController controller;

   @Mock
   private AccountRepository repository;

   @Test
   public void shouldSaveAccountToDb() {
      Account acc = new Account();
      acc.setUser(this.user);
      acc.setEmail(this.mail);

      doReturn(0).when(repository).countUserName(this.user);
      doReturn("Saved").when(repository).accountSaveTo(acc);

      ResponseEntity<String> result = controller.addAccount(acc);

      verify(repository, times(1)).accountSaveTo(acc);
      Assert.assertEquals("Saved", result.getEntity());

}