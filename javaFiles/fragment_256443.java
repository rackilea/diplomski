doReturn(null).when(file).list(argThat(new ArgumentMatcher<FilenameFilter>() {
    @Override
    public boolean matches(Object argument) {
        System.out.println("barbar");
        return true;
    }
}));