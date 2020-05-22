A mockedA = mock(A.class);
  B mockedB = mock(B.class);

  when(mockedA.method1(new ByteArrayInputStream("test".getBytes()))).thenReturn(null);
  when(mockedB.method2(new ByteArrayInputStream("test".getBytes()))).thenReturn(null);

  Service service = new Service(mockedA , mockedB );
  String i = service.test(new ByteArrayInputStream("test".getBytes()));

  System.out.println(i);