final ArgumentCaptor<String> arg1Captor = ArgumentCaptor.forClass(String.class);
final ArgumentCaptor<Object> arg2Captor = ArgumentCaptor.forClass(Object.class);
final ArgumentCaptor<Class<?>> arg3Captor = ArgumentCaptor.forClass(Class.class);

Mockito.verify(restTemplateMock).postForEntity(arg1Captor, arg2Captor, arg3Captor);

Assert.assertEquals("Whatever", arg1Captor.getValue());