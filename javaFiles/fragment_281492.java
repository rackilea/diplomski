when(serviceValidatorStub.validate(
    any(),
    isA(UserCommentRequestValidator.class),
    eq(UserCommentResponse.class),
    eq(UserCommentError.class))
).thenReturn(new UserCommentResponse());