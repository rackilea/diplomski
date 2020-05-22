@Test
 public void testShowProducts(@Cascading final FacesContext facesContext) {
        final Locale locale = new Locale(...)
        new Expectations() {
           {
              FacesContext.FacesContext.getCurrentInstance().getViewRoot().getLocale();
              returns(locale);
           }


        };
       ShowProducts sp = new ShowProducts();

       ...  do your assertions other stuff there
 }