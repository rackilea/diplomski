private static Customer createdObject;


  expectLastCall().andAnswer(new IAnswer<Customer>() {
      public Customer answer() throws Throwable {
          createdObject = (Customer) EasyMock.getCurrentArguments()[1];
          return null;
      }
  });