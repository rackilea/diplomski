@Test
    @UiThreadTest
    public void testLoginSuccess() {

        Instrumentation.ActivityMonitor monitor = InstrumentationRegistry.getInstrumentation().addMonitor(EventsListActivity.class.getName(), null, true);

        onView(withId(R.id.btnLogInW)).perform(click());
        onView(withId(R.id.email)).perform(typeText("good.email@example.com"));
        onView(withId(R.id.passL)).perform(typeText("strong.password"));
        onView(withId(R.id.btnLogInL)).perform(click());

        User user = new User();
        user.first_name = "Fake name";
        user.last_name = "Fake name";
        user.id = 1;
        user.email = "fake.email@gmail.com";

        final AuthResponse authResponse = new AuthResponse();
        authResponse.api_key = "fake_api_key";
        authResponse.status = "ok";
        authResponse.user = user;

        Mockito.verify(api).login(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), argumentCaptor.capture());
        InstrumentationRegistry.getInstrumentation().runOnMainSync(new Runnable() {
            @Override public void run() {
                argumentCaptor.getValue().success(authResponse, null);
            }
        });

        assertThat(1, equalTo(monitor.getHits()));
        InstrumentationRegistry.getInstrumentation().removeMonitor(monitor);
    }