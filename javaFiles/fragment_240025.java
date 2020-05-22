public enum Something {
    Value1(OneFragmentInterfaceImplementor.class), Value2(
            AnotherFragmentInterfaceImplementor.class);

    public final Class<? extends Fragment> fragment;

    private <T extends Fragment & Interface> Something(final Class<T> fragmentClass) {
        fragment = fragmentClass;
    }
}