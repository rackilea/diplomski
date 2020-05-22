Foo foo = new Foo();
Waldo waldo = mock(Waldo.class);
foo.setWaldo(waldo);
foo.bar();
verify(waldo).baz();
foo.bar();
verifyNoMoreInteractions(waldo);