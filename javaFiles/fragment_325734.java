@Test
  public void shouldUseReturnedProductFromDaoToLog() {
       // given
       Product product = mock(Product.class);
       Date creationDate = new Date();

       given(product.getCreationDate()).willReturn(creationDate);
       given(dao.create(any(Product.class)).willReturn(product);

       // when      
       Product createdProduct = main.createProduct();

       // then
       assertThat(createdProduct, is(equalTo(product)));
  }