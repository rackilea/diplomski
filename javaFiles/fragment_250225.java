List<B> listB = listA.stream().map(id -> {
         ObjectB b = Mockito.mock(ObjectB.class);
         when(b.getId()).thenReturn(id.toString());
         when(b.getNumericId()).thenReturn(id); 
         return b;
  })