@Test
    public void t012Mock(){
       BookingController controller = new BookingController();
       controller.em = mock(EntityManager.class);

       TypedQuery mockedQuery = mock(TypedQuery.class);

       when(controller.em.createNamedQuery("Booking.totalPerAccount",Double.class)).thenReturn(mockedQuery);

       when(mockedQuery.setParameter(anyString(), any())).thenReturn(mockedQuery);

       //getSingleResult should return null to test if its converted to 0....
       when(mockedQuery.getSingleResult()).thenReturn(null);
       double d = controller.totalPerAccount(new Account(0L,"Hallo")); //<-It doesn't matter which account

       //Check if the correct Methods are called
       verify(controller.em).createNamedQuery("Booking.totalPerAccount",Double.class);
       verify(mockedQuery).setParameter(anyString(), any());
       verify(mockedQuery).getSingleResult();

       //Methods should be called exactly once
       verify(mockedQuery,times(1)).getSingleResult();

       //if the query against the db returns null 0.0 should be returned.

       assertThat(0.0, is(d)); 
    }



@Test
    public void t013Mock(){
       BookingController controller = new BookingController();
       controller.em = mock(EntityManager.class);

       TypedQuery mockedQuery = mock(TypedQuery.class);

       //This is the statement i am looking for
       when(controller.em.createQuery("select b from Booking b", Booking.class)).thenReturn(mockedQuery);
       //return empty list... 
       when(mockedQuery.getResultList()).thenReturn(new LinkedList<Booking>());
       //Call method ignore return value
       controller.findAll();

       //verify that getResultList was called...
       verify(mockedQuery).getResultList();
       //Check that getResultList was called exactly once
       verify(mockedQuery,times(1)).getResultList();
    }