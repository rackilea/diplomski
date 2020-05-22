when(generalUtilmock.isObjectEmpty(ArgumentMatchers.<List<License>>any()))).thenAnswer(new Answer() {

    public Object answer(InvocationOnMock invocation) {
        Object[] args = invocation.getArguments();

        // if args contains a List<License> then return false
        // if args contains a List<AccountValidationResponseDTO> then return true
    }
});