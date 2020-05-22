ServiceClassA firstMock = mock(ServiceClassA.class);
ServiceClassB secondMock = mock(ServiceClassB.class);

Mockito.doNothing().when(firstMock).methodOne();   
Mockito.doNothing().when(secondMock).methodTwo();  

//create inOrder object passing any mocks that need to be verified in order
InOrder inOrder = inOrder(firstMock, secondMock);

//following will make sure that firstMock was called before secondMock
inOrder.verify(firstMock).methodOne();
inOrder.verify(secondMock).methodTwo();