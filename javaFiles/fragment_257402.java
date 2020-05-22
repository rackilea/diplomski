//You can mock concrete classes, not only interfaces
 A mockedA = mock(A.class);
 B mockedB = mock(A.class);

 //stubbing
 when(mockedA.method1(any(InputStream.class))).thenReturn(null);
 when(mockedB.method2(any(InputStream.class))).thenReturn(null);