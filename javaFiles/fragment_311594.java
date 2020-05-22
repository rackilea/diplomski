ArgumentCaptor<Object> captor = ArgumentCaptor.for(Object.class);
when(api.mockedMethod(any()).thenReturn(3L);
testedMethod();
verify(api).mockedMethod(captor.capture());

// Now you can check the object, as needed, using your own methods.
checkObjectAsNeeded(captor.getValue());