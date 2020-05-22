SomeClassTest someClassInstance = new SomeClassTest();
doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                mServiceVCallback.onResult(int_I_want_to_test_for)
                return null;
            }
        }).when(someClassInstance).service_request_before_latch_await();
int response = someClassInstance.callToExternalService();
assertEquals(response, expected_response);