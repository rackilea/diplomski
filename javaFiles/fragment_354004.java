when(mock.getSomeStuff(any(Criteria.class))).thenAnswer(new Answer<Integer>{
        @Override
        public Integer answer(InvocationOnMock invocation) throws Throwable {
           // inspect args in invocation and return
           // ...
        }
   });