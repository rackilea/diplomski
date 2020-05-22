//Given
MyService service = new MyService();
MyService serviceSpy = Mockito.spy(service);

//When
serviceSpy.call();

//Then
long count = Mockito.mockingDetails(serviceSpy)
      .getInvocations()
      .stream()
      .filter(i -> i.toString().contains("service.call()"))
      .count();

if (count > 0)
    System.out.println("Method was called " + count + " times.");
else
    System.out.println("Method wasn't called at all.");

//TODO: of course this isn't correct test because it hasn't any assertions.