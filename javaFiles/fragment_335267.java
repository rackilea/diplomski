Class Permission implements ContainerRequestContext
{
    @context
    HttpServletRequest servletRequest;

    public void filter(ContainerRequestContext containerRequestContext) throws IOException 
    {
          ...
    }

   void setHttpServletRequest(HttpServletRequest servletRequest) {
     this.servletRequest = servletRequest;
   {
}

 @RunWith(MockitoJUnitRunner.class)
 class Test {

     private Permission permission = new Permission();
     @Mock
     private HttpServletRequest servletRequest;

     @Test
     public void test()
     {
        permission.setHttpServletRequest(servletRequest);
        permission.filter(...);
     }
  }