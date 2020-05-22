@Component
@DependsOn("testBean")
@CustomAnnotation
public class Foo {
}

@Service("testBean")
public class TestBean {

   @Autoware
   private Application context;

   @PostContruct
   public void init() {
      context.getBeansWithAnnotation(CustomAnnotation.class);
   }
}