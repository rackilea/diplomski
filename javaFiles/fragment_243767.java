public static void main(String[] args) throws Exception {
    Computer computer = new Computer();

    JUnitCore jUnitCore = new JUnitCore();
    Field field = JUnitCore.class.getDeclaredField("fNotifier");
    field.setAccessible(true);
    RunNotifier runNotifier = (RunNotifier) field.get(jUnitCore);
    runNotifier.pleaseStop();
    jUnitCore.run(computer, BeforeAfterTest.class, AssertionErrorTest.class);
}