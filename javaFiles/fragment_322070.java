@Test
public void testSuppressSuperclassMethods() {
    PowerMockito.suppress(MemberMatcher.methodsDeclaredIn(Parent.class));
    Child child = spy(Child.class);
    child.method();
}