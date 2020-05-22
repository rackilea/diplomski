@Mock
    NotificationCompat.Builder notificationBuilder;

    @Before
    public void setUp(){
        notificationBuilder = Mockito.mock(NotificationCompat.Builder
                .class);

    }
   @Test
    public void testSharedPrefInjection(){

        assertNotNull(notificationBuilder);
    }