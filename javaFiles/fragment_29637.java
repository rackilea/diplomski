@Configuration
public class AppPropertiesBundle
{

   @Configuration
   @PropertySource(name = "PropsA", value = "classpath:app-props.properties")
   @ConfigurationProperties(prefix = "a")
   public static class A extends AppProperties
   {
   }

   @Configuration
   @PropertySource(name = "PropsB", value = "classpath:app-props.properties")
   @ConfigurationProperties(prefix = "b")
   public static class B extends AppProperties
   {
   }

}