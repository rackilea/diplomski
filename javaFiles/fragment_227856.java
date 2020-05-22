@Test
       public void getById() throws RecordNotFoundException{
         // if it's List in your case
         Optional<Object> objectList = Optional.of(Arrays.asList(new YourType()));              
         given(objectDao.findById(Mockito.anyLong())).willReturn(objectList); 
         Object returnedObject = objectServiceImpl.getById(1L);
         Mockito.verify(objectDao).findById(Mockito.anyLong());
         assertNotNull(returnedObject);
      }