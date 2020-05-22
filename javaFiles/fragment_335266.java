@RunWith(MockitoJUnitRunner.class)
class Test {

   @InjectMocks
   private Permission permission;
   @Mock
   private HttpServletRequest servletRequest;

   @Test
   public void test()
   {
       permission.filter(...);
   }
}