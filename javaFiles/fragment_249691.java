protected <S extends AbstractPage> M setup(final S s, final String errorMsg) {
    for (final Module m : s.getModules()) {
        if (m.getClass().equals(type)) {
            @SuppressWarnings("unchecked")
            M result = (M) m;
            return result;
        }
    }
    Assert.fail(errorMsg); 
}