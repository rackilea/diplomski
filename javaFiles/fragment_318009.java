public class MyTransformer implements IAnnotationTransformer {

  private final int counter;

  public MyTransformer() {
    String count = System.getProperty("count", "100");
    counter = Integer.parseInt(count);
  }

  public void transform(ITest annotation, Class<?> testClass,
      Constructor testConstructor, Method testMethod) {
    if (testMethod.getName().contains("TC_02_InstructorCreatesCourse")) {
      System.out.println("The listener is activated for:-" + testMethod.getName());
      annotation.setInvocationCount(20);
      System.out.println("Invocation count is set to :-" + counter);
    }
  }
}