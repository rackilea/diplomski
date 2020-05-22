@Test
public void shouldSetCreationDateAtProductWhenCreatingIt() {
     // given
     Product product = mock(Product.class);

     // when
     dao.create(product);

     // then
     verify(product).setCreationDate(argThat(is(not(nullValue(Date.class)))));
}