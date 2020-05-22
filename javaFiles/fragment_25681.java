public class DoStandardLoginUsecaseTest {

      private DoStandardLoginUsecase target;
      private MyApplication contextMock;

      @Before
      public void beforeEach() {
          contextMock = Mockito.mock(MyApplication.class);
          // Note that you need to mock the getPresenterComponent
          // but I don't know what it returns.
          target = new DoStandardLoginUsecase(contextMock);
      }

      @Test
      public void buildUseCaseObservable() {
           UserDataRepository userDataMock = Mockito.mock(UserDataRepository.class);
           StandardLoginInfo loginInfoMock = Mockito.mock(StandardLoginInfo.class);
           target.mUserDataRepo = userDataMock;
           target.setLoginInfo(loginInfoMock);

           Observable<Login> expected = // create your expected test data however you like...
           Mockito.when(userDataMock.doStandardLogin(loginInfoMock)).thenReturn(expected);
           Observable<Login> actual = target.buildUseCaseObservable();

           Assert.areSame(actual, expected);
      }

 }