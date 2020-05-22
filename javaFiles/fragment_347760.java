when(Calendar.getInstance())
    .thenAnswer(new Answer<Calendar>() {
        Calendar answer(InvocationOnMock invocation) {
            return // however you're instantiating it
    }
});