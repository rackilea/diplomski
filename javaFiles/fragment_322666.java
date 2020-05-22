Mockito.doAnswer(new Answer() {
          public Object answer(InvocationOnMock invocation) {
              Object[] args = invocation.getArguments();
              AccountProductPojo accountProduct = (AccountProductPojo) args[0];
              accountProduct.setProduct(new ProductPojo(PRODUCT_ID_CONSTANT, PRODUCT_NAME_CONSTANT));
              return null;
          }}).when(accountProductRepository).refresh(Mockito.any());