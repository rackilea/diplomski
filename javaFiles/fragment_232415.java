@Mock
  private INotificationDao iNotificationDao;
  private ClassName className;

  @Before
  public void init() {
    className = spy(new ClassName());
  }

  @Test
  public void storeInfoInStagingGivenStaginInfoValid() {
    Mockito.doNothing().when(className).storeInfoStaging(stagingInfo);
    className.storeInfoStaging(storeInfo);
    Mockito.verify(iNotificaDao, atLeastOnce()).storeInfoStaging(staginInfo);
  }