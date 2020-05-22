@Test
public void toStackOvflow2() throws Exception {
    ResourceConfig resConf = mock(ResourceConfig.class);

    // suppress TooManyConstructorsFoundException
    MemberModifier.suppress(MemberMatcher.constructorsDeclaredIn(ResourceConfig.class));
    whenNew(ResourceConfig.class).withNoArguments().thenReturn(resConf);

    // verifying that the expected ResourceConfig instance is returned when using the default ctor ...
    assertSame(resConf, new ResourceConfig());
}