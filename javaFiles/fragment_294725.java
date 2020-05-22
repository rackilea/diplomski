@bean
public class ClassLoaderHolderBean implements ClassLoaderHolder {
   @Autowired 
   ApplicationContext context;

   @override
   public ClassLoader getClassLoader() {
     return context.getClassLoader();
   }
}