PowerMockito.when(
        validator,
        method(CommentValidator.class, "isCaptchaValid",
        HttpServletRequest.class))
    .withArguments(Mockito.any())
    .thenReturn(true);