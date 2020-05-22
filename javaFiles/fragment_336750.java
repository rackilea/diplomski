Application application = mock(Application.class);
List<Application> aps = Collections.singletonList(new Application());

when(application.findSomething(any(), anyVararg())).thenReturn(aps);

System.out.println(application.findSomething("foo").size());
System.out.println(application.findSomething("bar", 17).size());
System.out.println(application.findSomething(new Object(), 17, 18, 19, 20).size());