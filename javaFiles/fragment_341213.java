@RunWith(JMock.class)
public class Example {

  private Mockery context = new JUnit4Mockery();

  @Test
  public void Test() {

    final IDependency mockObject = context.mock(IDependency.class);

    context.checking(new Expectations() {
      {
        // No custom matcher required here
        allowing(mockObject).methodToInvoke(with(any(Integer.class)));

        // The action will return the first argument of the method invocation.
        will(new CustomAction("returns first arg") {
          @Override
          public Object invoke(Invocation invocation) throws Throwable {
            return (Integer) invocation.getParameter(0);
          }
        });
      }
    });

    Integer test1 = 1;
    Integer test2 = 1;

    // Confirm the object passed to the mocked method is returned
    Assert.assertEquals((Object) test1, mockObject.methodToInvoke(test1));
    Assert.assertEquals((Object) test2, mockObject.methodToInvoke(test2));
  }

  public interface IDependency {
    public int methodToInvoke(int arg);
  }