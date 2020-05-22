static class TestClass {

    public String getThing() {
        return "Thing";
    }

    public String getOtherThing() {
        return getThing();
    }
}

public static void main(String[] args) {
    final TestClass testClass = Mockito.spy(new TestClass());
    Mockito.when(testClass.getThing()).thenReturn("Some Other thing");
    System.out.println(testClass.getOtherThing());
}