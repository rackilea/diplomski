@Named
@Transactional
public class AuditEmptyInterceptor extends EmptyInterceptor {  

     @PostConstruct
     public void init() {
          StaticDelagateInterceptor.setInterceptor(this);
     }
     ...
}