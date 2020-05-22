@Test
public void givenCall1_whenRedefined_thenReturnFooRedefined() throws Exception {
    ByteBuddyAgent.install();

    new ByteBuddy()
        .redefine(Call1.class)
        .method(named("callingCall2"))
        .intercept(to(Interceptor.class))
        .make()
        .load(ByteBuddyTest2.class.getClassLoader(),
              ClassReloadingStrategy.fromInstalledAgent());

    Call1 f = new Call1();
    assertEquals(f.callingCall2().getModel(), "2011");
    assertEquals(f.callingCall2().getName(), "Maruti");
}

public static class Interceptor {
    public static Car callingCall2() {
      Car carTest = new Car();
      carTest.setModel("2011");
      carTest.setName("Maruti");
      return carTest;
    }
}