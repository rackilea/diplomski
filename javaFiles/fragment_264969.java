@Test
public void exampleTest(@Mocked Foo foo) {
    new ClassUnderTest().unitUnderTest();

    new Verifications() {{ foo.setExtraFooness("whatever"); }};
}