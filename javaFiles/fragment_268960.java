object.setX(-1);
Mockito.doAnswer(new Answer<Void>() { 
        public Void answer(InvocationOnMock invocation) throws Throwable { 
                assertEquals(1, object.getX());
                return null; 
        } 
}).when(myObjectRepositoryMock).update(object);