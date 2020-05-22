public class KnockoutValidation {

   @Autowired
   AccessBeanFactory fact;

   public boolean runFormValidation(String param1, boolean param1, final String param3) {
       //...

       AccessBean bean = (AccessBean) fact.getAccessBean("abc", "xyz");
       //....
   }
}