Set<Object> blocked = new HashSet<>();
Test m = mock(Test.class);
doAnswer(invocation -> blocked.add(invocation.getArguments()[0]))
    .when(m).block(any());
when(m.blocked(any()))
    .thenAnswer(invocation -> !blocked.contains(invocation.getArguments()[0]));