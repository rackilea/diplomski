when(myService.saveMyEntity(eq(TENANT_ID), any(User.class), any(MyEntity.class))).thenAnswer(
        new Answer<MyEntity>() {
            @Override
            public MyEntity answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                return (MyEntity) args[2];
            }
        } );