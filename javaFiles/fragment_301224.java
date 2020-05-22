Foo mock = mock(Foo.class, RETURNS_DEEP_STUBS);

// note that we're stubbing a chain of methods here: getBar().getName()
when(mock.getBar().getName()).thenReturn("deep");

// note that we're chaining method calls: getBar().getName()
assertEquals("deep", mock.getBar().getName());