B b = new B();
A a = Mockito.mock(A.class);
C c = new C();
Mockito.when(a.getTarget(Mockito.any(C.class)).thenReturn(c);
boolean isPresent = b.someMethodToTest();
assertEquals("someMethodToTest was supposed to return true", true/*expected*/, isPresent);